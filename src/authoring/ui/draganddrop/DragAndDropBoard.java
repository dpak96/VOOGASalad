package authoring.ui.draganddrop;

import authoring.controller.AuthoringController;
import javafx.scene.layout.Pane;


public class DragAndDropBoard extends AbstractDragAndDrop {

  public DragAndDropBoard(AuthoringController authoringController) {
      super(authoringController);
      setListeners();

  }


    public void setListeners() {
    	this.setOnDragDropped(event -> myAuthoringController.callEvent("DragAndDropController","dropElement",event));
        this.setOnDragOver(event -> myAuthoringController.callEvent("DragAndDropController","dragOn",event));
        this.setOnMouseClicked(event -> myAuthoringController.callEvent("DragAndDropController","addTemp",event));
    }



}
