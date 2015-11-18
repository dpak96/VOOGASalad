package authoring.ui;

import authoring.ui.draganddrop.DragAndDropBoard;
import authoring.ui.smalloverlay.OverlayControllerEx;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class AuthoringUI {
  private DragAndDropBoard dragAndDrop;


  public AuthoringUI(){

  }

  public Pane tester(){
    OverlayControllerEx oc = new OverlayControllerEx();
    oc.init();
    return oc.getModule();
  }

  public DragAndDropBoard getDragAndDrop() {
    return dragAndDrop;
  }


  public void setDragAndDrop(DragAndDropBoard dragAndDrop) {
    this.dragAndDrop = dragAndDrop;
  }



}
