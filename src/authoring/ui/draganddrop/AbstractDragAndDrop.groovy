package authoring.ui.draganddrop

import authoring.controller.AuthoringController

public abstract class AbstractDragAndDrop {

    public AbstractDragAndDrop(AuthoringController authoringController) {
        setListeners(authoringController);
    }

    abstract void setListeners();


    protected void setListeners(AuthoringController authoringController) {
        this.setOnDragDropped({event -> authoringController.callEvent("DragAndDropController","dropElement",event)});
        this.setOnDragOver({event -> authoringController.callEvent("DragAndDropController","dragOn",event)});
        this.setOnMouseClicked({event -> authoringController.callEvent("DragAndDropController","addTemp",event)});
    }
}
