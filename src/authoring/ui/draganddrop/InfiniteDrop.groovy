package authoring.ui.draganddrop

import authoring.controller.AuthoringController

/**
 * Created by Rob on 12/9/15.
 */
public class InfiniteDrop extends AbstractDragAndDrop {

    public InfiniteDrop(AuthoringController ac){
        super(ac);
    }

    @Override
    protected void setListeners(AuthoringController authoringController) {
        this.setOnDragDropped({});
//        this.setOnDragOver({});
//        this.setOnMouseClicked({});
    }


}
