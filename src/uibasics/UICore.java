package uibasics;

import java.util.Optional;

import action.controller.ActionController;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import main.GraphicHandler;
import main.VoogaProperties;
import menu.MenuController;
import model.controller.ModelController;
import startscreen.GameCreation;


public class UICore {

  private BorderPane myRoot;
  private UIStackPane uiStackPane;
  private MenuController menuController;
  private Scene myScene;

  public UICore(GraphicHandler graphicHandler, ActionController actionController, ModelController modelController) {
    uiStackPane = new UIStackPane(modelController);
    VoogaProperties props = new VoogaProperties();
    myRoot = new BorderPane();
    menuController = new MenuController(graphicHandler, modelController);
    myScene = new Scene(myRoot, props.getSceneWidth(), props.getSceneHeight());
    borderInit(props);
    myScene.setOnKeyPressed(e -> actionController.update(e.getCode().toString()));
    myScene.setOnMouseClicked(e -> actionController.update(e.toString()));
    pauseInit(actionController);
  }
  

  public void borderInit(VoogaProperties props) {
    myRoot.setCenter(uiStackPane);
    myRoot.setTop(menuController.getMenu());
    myRoot.setPrefWidth(props.getSceneWidth());
    myRoot.setPrefHeight(props.getSceneHeight());
  }
  
  public void initPanels(GameCreation game) {
	uiStackPane.initPanes(game);
  }

  public Scene getScene() {
    myScene.getStylesheets().addAll("authoring/Overlay.css");
    return myScene;
  }

  public Pane getStack() {
    return uiStackPane.getStack();
  }

  public UIStackPane getUIStackPane() {
    return uiStackPane;
  }

  public UIBasics getUIBasics() {
    return uiStackPane.getUIBasics();
  }

  public MenuController getMenu() {
    return menuController;
  }
  
  private void pauseInit(ActionController actionController){
	  menuController.getMenu().getPlayer().setOnAction(e->actionController.resume());
	  menuController.getMenu().getPauser().setOnAction(e->actionController.change_rate(0));
	  menuController.getMenu().getStepper().setOnAction(e->actionController.stepper());
  }
  
  /*HELPFUL CODE FOR FUTURE DIALOGS (EXIT, STOP, etc.)
   * private void pauser(ActionController actionController){
	  PauseDialog pause = new PauseDialog();
	  actionController.change_rate(0);
	  Optional<String> ret = pause.showAndWait();
	  if(ret.isPresent()){
		  switch (ret.get()){
		  	case "Resume":
		  		actionController.resume();
		  		break;
		  	case "Authoring Environment":
		  		menuController.switchOverlay();
		  		break;
		  	case "Return to Main":
		  		menuController.newStart();
		  		break;
		  	default:
		  		
		  }
	  }
  }*/

}
