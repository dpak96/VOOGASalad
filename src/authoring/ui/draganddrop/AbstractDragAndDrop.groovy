package authoring.ui.draganddrop


import authoring.controller.AuthoringController
import javafx.scene.layout.Pane

public abstract class AbstractDragAndDrop extends Pane {
    public AbstractDragAndDrop(AuthoringController authoringController) {
        setListeners(authoringController);
    }

    protected abstract void setListeners(AuthoringController authoringController);

}
