package authoring.ui.draganddrop;

import authoring.controller.AuthoringController;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;


public class DragAndDropBoard extends Pane {

  public DragAndDropBoard(AuthoringController authoringController) {
      dragDropped(authoringController);
  }

    protected void dragDropped(AuthoringController authoringController) {
        this.setOnDragDropped(event -> authoringController.dropElement(event));
        this.setOnDragOver(event -> authoringController.dragOn(event));

         }
}
