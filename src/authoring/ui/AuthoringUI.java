package authoring.ui;

import authoring.controller.AuthoringController;
import authoring.ui.draganddrop.DragAndDropBoard;
import authoring.ui.smalloverlay.OverlayController;
import authoring.ui.smalloverlay.OverlayControllerEx;
import authoring.ui.toolbar.ButtonOverlay;
import authoring.ui.toolbar.ToolbarContainer;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import main.VoogaProperties;

public class AuthoringUI {
  private DragAndDropBoard dragAndDrop;
  private OverlayController myOverlayController;
  private ToolbarContainer myToolbarContainer;
  private OverlayController test;
  private Pane ov2;



  public AuthoringUI(AuthoringController authoringController){
    dragAndDrop = new DragAndDropBoard(authoringController);
    myOverlayController = new OverlayController();
    myToolbarContainer = new ToolbarContainer(authoringController);
  }

  public Pane tester(){
    ov2 = new Pane();
    test = new OverlayController();
    Pane toolbar = myToolbarContainer.initializeToolbar();
    test.getChildren().add(toolbar);
    VoogaProperties props = new VoogaProperties();
    dragAndDrop.getStyleClass().add("Thingy");
    return ov2;
  }

  public void init(){
    ov2.getChildren().addAll(dragAndDrop,test);
    dragAndDrop.setPrefSize(500,500);
    test.setLayoutX(500);
  }




  public DragAndDropBoard getDragAndDrop() {
    return dragAndDrop;
  }


  public void setDragAndDrop(DragAndDropBoard dragAndDrop) {
    this.dragAndDrop = dragAndDrop;
  }



}
