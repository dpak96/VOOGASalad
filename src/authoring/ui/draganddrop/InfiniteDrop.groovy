package authoring.ui.draganddrop

import authoring.controller.AuthoringController


public class InfiniteDrop extends AbstractDragAndDrop {

    public InfiniteDrop(AuthoringController ac){
        super(ac);
    }

    @Override
    protected void setListeners(AuthoringController authoringController) {
        this.setOnDragDropped({event ->  authoringController.callEvent("InfiniteController", "makeArticle",event)});
        this.setOnDragOver({});
        this.setOnMouseClicked({});
    }


}
