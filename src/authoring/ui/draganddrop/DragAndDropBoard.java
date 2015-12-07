package authoring.ui.draganddrop;

import authoring.controller.AuthoringController;
import javafx.scene.layout.Pane;


public class DragAndDropBoard extends Pane {

  public DragAndDropBoard(AuthoringController authoringController) {
      setListeners(authoringController);
  }

    protected void setListeners(AuthoringController authoringController) {
        this.setOnDragDropped(event -> authoringController.dragEvent("dropElement",event));
        this.setOnDragOver(event -> authoringController.dragEvent("dragOn",event));
        this.setOnMouseClicked(event -> authoringController.dragEvent("addTemp",event));
    }
}
