package authoring.ui.draganddrop;

import authoring.controller.AuthoringController;
import authoring.ui.editingmenus.ArticlePropertyEditorMenu;
import authoring.ui.toolbar.ToolbarButton;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import model.article.Article;


public class DragAndDropBoard extends Pane {

  public DragAndDropBoard(AuthoringController authoringController) {
    dragEntered();
    dragDropped(authoringController);
    dragOver();
  }

  protected void dragEntered() {
    this.setOnDragEntered(new EventHandler<DragEvent>() {
      @Override
      public void handle(DragEvent event) {
        /* the drag-and-drop gesture entered the target */
        /* show to the user that it is an actual gesture target */
        if (event.getGestureSource() != this && event.getDragboard().hasImage()) {
          // ida.inArea();
        }
        event.consume();
      }
    });
  }


    protected void dragDropped(AuthoringController authoringController){
        this.setOnDragDropped(new EventHandler <DragEvent>() {
            @Override
            public void handle(DragEvent event) {
                authoringController.thingy(event);
            }
        });
        this.setOnMouseClicked(e->
                authoringController.addTemp(e));
    }

  protected void dragOver() {
    this.setOnDragOver(new EventHandler<DragEvent>() {
      @Override
      public void handle(DragEvent event) {
        /* data is dragged over the target */
        // System.out.println("onDragOver");

        /*
         * accept it only if it is not dragged from the same node
         * and if it has a string data
         */
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
