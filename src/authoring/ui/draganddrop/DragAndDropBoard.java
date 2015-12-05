package authoring.ui.draganddrop;

import authoring.controller.AuthoringController;
import authoring.ui.editingmenus.ArticlePropertyEditorMenu;
import authoring.ui.toolbar.ToolbarButton;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
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
                /* data dropped */
                if(event.getGestureSource() instanceof HighlightedArticle){
                    HighlightedArticle highlightedArticle = (HighlightedArticle) event.getGestureSource();
                   double tempX = highlightedArticle.getLayoutX()+0.1;
                    double tempY = highlightedArticle.getLayoutY()+0.1;
                    Article n = authoringController.getArticleFromCoordinates(tempX,tempY);
                    //System.out.println(n == null);
                    n.setX(event.getX());
                    n.setY(event.getY());
                }
                else {
                    authoringController.createAndPlaceArticle(event.getX(), event.getY(), (DraggableElement) event.getGestureSource());
                }
                Dragboard db = event.getDragboard();
                boolean success = false;
                if (db.hasImage()) {
                    success = true;
                }
                event.setDropCompleted(success);
                event.consume();
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
