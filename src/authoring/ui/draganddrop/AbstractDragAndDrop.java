package authoring.ui.draganddrop;


import authoring.controller.AuthoringController;
import javafx.scene.layout.Pane;

public abstract class AbstractDragAndDrop extends Pane {
    protected AuthoringController myAuthoringController;
    public AbstractDragAndDrop(AuthoringController authoringController) {
        myAuthoringController = authoringController;
        //setListeners(authoringController);
    }

    //public abstract void setListeners(AuthoringController authoringController);

}
