package authoring.ui.draganddrop;


import authoring.controller.AuthoringController;
import authoring.ui.toolbar.ToolbarButton;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.StackPane;

public class DragAndDropBoard extends StackPane {

    public DragAndDropBoard(AuthoringController authoringController) {
        dragEntered();
        dragDropped(authoringController);
        dragOver();
    }

    protected void dragEntered(){
        this.setOnDragEntered(new EventHandler<DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                /* the drag-and-drop gesture entered the target */
                /* show to the user that it is an actual gesture target */
                if (event.getGestureSource() != this && event.getDragboard().hasImage()) {
                    //ida.inArea();
                }
                event.consume();
            }
        });
    }

    protected void dragDropped(AuthoringController authoringController){
        this.setOnDragDropped(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                /* data dropped */
                System.out.println("onDragDropped");
                System.out.println(event.getX()+","+event.getY());
                authoringController.createAndPlaceArticle(event.getX(),event.getY(), (ToolbarButton) event.getGestureSource());

                /* if there is a string data on dragboard, read it and use it */
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasImage()) {

                    success = true;
                }
                /* let the source know whether the string was successfully
                 * transferred and used */
                event.setDropCompleted(success);
                event.consume();
            }
        });
        this.setOnMouseClicked(e->
                getChildren().add(authoringController.getArticleFromCoordinates(e.getX(),e.getY())));

    }


    protected void dragOver(){
        this.setOnDragOver(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                /* data is dragged over the target */
                //System.out.println("onDragOver");

                /* accept it only if it is  not dragged from the same node
                 * and if it has a string data */
                if (event.getGestureSource() != this &&
                        event.getDragboard().hasImage()) {
                    /* allow for moving */
                    event.acceptTransferModes(TransferMode.MOVE);
                }

                event.consume();
            }
        });
    }
}