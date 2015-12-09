package authoring.ui.draganddrop;

import authoring.controller.AuthoringController;


public class InfiniteDrop extends AbstractDragAndDrop {

    public InfiniteDrop(AuthoringController ac){
        super(ac);
        setListeners();
    }

    public void setListeners() {
        this.setOnDragDropped(event ->  System.out.println("hi"));
        this.setOnDragOver(event -> myAuthoringController.callEvent("InfiniteController","dragOn",event));
    }


}
