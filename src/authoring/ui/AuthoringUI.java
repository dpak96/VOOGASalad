package authoring.ui;

import authoring.controller.AuthoringController;
import authoring.ui.draganddrop.DragAndDropBoard;
import authoring.ui.smalloverlay.OverlayController;
import authoring.ui.smalloverlay.OverlayControllerEx;
import authoring.ui.toolbar.ButtonOverlay;
import authoring.ui.toolbar.ToolbarContainer;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import main.VoogaProperties;

public class AuthoringUI {
  private DragAndDropBoard dragAndDrop;
  private OverlayController myOverlayController;
  private ToolbarContainer myToolbarContainer;
  private OverlayController test, tester;
  private Pane ov2;
  private FlowPane toolbar;
  AuthoringController ac;


  public AuthoringUI(AuthoringController authoringController){
    dragAndDrop = new DragAndDropBoard(authoringController);
    myOverlayController = new OverlayController();
    myToolbarContainer = new ToolbarContainer(authoringController);
     ac = authoringController;
  }

  public Pane tester(){
    ov2 = new Pane();
    test = new OverlayController();
    tester = new OverlayController();
    toolbar = myToolbarContainer.initializeToolbar();
    toolbar.setPrefWidth(250);
    toolbar.getStyleClass().add("Thinger");
    test.getChildren().add(toolbar);
    VoogaProperties props = new VoogaProperties();
    tester.getChildren().add(dragAndDrop);
    dragAndDrop.getStyleClass().add("Thingy");
    test.getStyleClass().add("Thingy");
    return ov2;
  }

  public void init(){
//    Button b = new Button("hi");
//    dragAndDrop.getChildren().add(b);
//    b.setOnAction(e->ac.randomTest());
    ov2.getChildren().addAll(tester,test);
    VoogaProperties vp = new VoogaProperties();
    tester.setPrefSize(vp.getSceneWidth(),vp.getSceneHeight());
    dragAndDrop.setPrefSize(vp.getSceneWidth(),vp.getSceneHeight());
    test.setLayoutY(0);
    test.setLayoutX(vp.getSceneWidth()-(toolbar.getBoundsInParent().getWidth()*9));
    test.setMaxWidth((toolbar.getBoundsInParent().getWidth()*8));
  }




  public DragAndDropBoard getDragAndDrop() {
    return dragAndDrop;
  }

  public Pane getTester(){
    return tester;
  }

  public void setDragAndDrop(DragAndDropBoard dragAndDrop) {
    this.dragAndDrop = dragAndDrop;
  }



}
