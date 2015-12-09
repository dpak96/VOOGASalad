package authoring.ui.draganddrop;

import authoring.controller.AuthoringController;
import javafx.scene.layout.Pane;


public class DragAndDropBoard extends Pane {

  public DragAndDropBoard(AuthoringController authoringController) {
      setListeners(authoringController);
  }

    protected void setListeners(AuthoringController authoringController) {
        this.setOnDragDropped(event -> authoringController.callEvent("DragAndDropController","dropElement",event));
        this.setOnDragOver(event -> authoringController.callEvent("DragAndDropController","dragOn",event));
        this.setOnMouseClicked(event -> authoringController.callEvent("DragAndDropController","addTemp",event));
    }
}
