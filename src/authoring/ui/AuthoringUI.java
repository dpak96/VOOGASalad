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

public class AuthoringUI {
  private DragAndDropBoard dragAndDrop;
  private OverlayController myOverlayController;
  private ToolbarContainer myToolbarContainer;
  private OverlayController test;



  public AuthoringUI(AuthoringController authoringController){
    dragAndDrop = new DragAndDropBoard(authoringController);
    myOverlayController = new OverlayController();
    myToolbarContainer = new ToolbarContainer();
  }

  public Pane tester(){
    BorderPane ov2 = new BorderPane();
    test = new OverlayController();
    Pane toolbar = myToolbarContainer.initializeToolbar();
    test.getStyleClass().add("Test");
    test.getChildren().add(toolbar);
    ov2.setRight(test);
    // ov2.setMargin(toolbar, new Insets(0,0,0,5));
    ov2.setLeft(dragAndDrop);
    dragAndDrop.getStyleClass().add("Thingy");
    myOverlayController.addPane(ov2);
    return myOverlayController;
  }


  public DragAndDropBoard getDragAndDrop() {
    return dragAndDrop;
  }


  public void setDragAndDrop(DragAndDropBoard dragAndDrop) {
    this.dragAndDrop = dragAndDrop;
  }



}
