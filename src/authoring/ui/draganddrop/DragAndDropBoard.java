package authoring.ui.draganddrop;

import authoring.controller.AuthoringController;
import javafx.scene.layout.Pane;


public class DragAndDropBoard extends Pane {

  public DragAndDropBoard(AuthoringController authoringController) {
    dragDropped(authoringController);
  }

    protected void dragDropped(AuthoringController authoringController) {
        this.setOnDragDropped(event -> authoringController.dropElement(event));
    }
}
