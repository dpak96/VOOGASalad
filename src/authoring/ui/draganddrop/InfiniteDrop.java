package authoring.ui.draganddrop;

import authoring.controller.AuthoringController;


public class InfiniteDrop extends AbstractDragAndDrop {

    public InfiniteDrop(AuthoringController ac){
        super(ac);
        setListeners();
    }

    public void setListeners() {
        this.setOnDragDropped(event ->  myAuthoringController.callEvent("InfiniteController", "makeArticle",event));
        this.setOnDragOver(event -> myAuthoringController.callEvent("InfiniteController","dragOn",event));
    }


}
