package uibasics;

import java.util.Observable;
import java.util.Observer;

import authoring.controller.AuthoringController;
import game.player.GamePlayerOverlay;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import model.Model;
import model.controller.ModelController;
import startscreen.GameCreation;
import startscreen.GameCreation.Mode;

public class UIStackPane extends StackPane implements Observer {
	private UIBasics myUIBasics;
	private AuthoringController myAuthoringController;
	private GamePlayerOverlay myGamePlayer;
	private boolean edit;
	private Pane myAuthoringControllerPane;
	private ModelController myModelController;
	
	public UIStackPane(ModelController modelController) {
		myModelController = modelController;
		myAuthoringController = new AuthoringController(modelController);
		initializePanes();
	}

	public void initializePanes() {
		edit = true;
		myUIBasics = new UIBasics(myModelController);
		myGamePlayer = new GamePlayerOverlay();
		myAuthoringControllerPane = myAuthoringController.getUi().tester();
	}
	
	public void initPanes(GameCreation game) {
		this.getChildren().clear();
		this.getChildren().add(myUIBasics.getPane());
		if (game.getMode() == Mode.play) {
			edit=false;
			this.getChildren().add(myGamePlayer);
		} else {
			edit=true;
			this.getChildren().add(myAuthoringControllerPane);
		}
	}
	
	public void toggle() {
		this.getChildren().remove(this.getChildren().size()-1);
		if (edit) {
			this.getChildren().add(myGamePlayer);
		} else {
			this.getChildren().add(myAuthoringControllerPane);
		}
		edit=!edit;
	}
	
	 public AuthoringController getAuthoringController() {
		 return myAuthoringController;
	 }

	 public void setAuthoringController(AuthoringController authoringController) {
		 this.myAuthoringController = authoringController;
	 }
	
	public StackPane getStack(){
		return this;
	}
	
	public UIBasics getUIBasics(){
		return myUIBasics;
	}
	
	public GamePlayerOverlay getGamePlayer(){
		return myGamePlayer;
	}

	@Override
	public void update(Observable o, Object arg) {
		Model model = (Model) o;
		myUIBasics.update(model.getArticles(), model.getCharacter());
		myGamePlayer.update(model.getArticles(), model.getCharacter());
	}

}
