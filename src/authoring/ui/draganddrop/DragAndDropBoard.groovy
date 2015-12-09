package authoring.ui.draganddrop;

import authoring.controller.AuthoringController;
import javafx.scene.layout.Pane;


public class DragAndDropBoard extends AbstractDragAndDrop {

  public DragAndDropBoard(AuthoringController authoringController) {
      super(authoringController);
  }

    @Override
    protected void setListeners(AuthoringController authoringController) {
        this.setOnDragDropped({event -> authoringController.callEvent("DragAndDropController","dropElement",event)});
        this.setOnDragOver({event -> authoringController.callEvent("DragAndDropController","dragOn",event)});
        this.setOnMouseClicked({event -> authoringController.callEvent("DragAndDropController","addTemp",event)});
    }



}
