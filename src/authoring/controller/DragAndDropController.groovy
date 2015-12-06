package authoring.controller

import authoring.ui.draganddrop.DraggableElement
import authoring.ui.draganddrop.HighlightedArticle
import authoring.ui.editingmenus.ArticlePropertyEditorMenu
import imageextender.ImageExtender
import javafx.scene.control.Button
import javafx.scene.input.DragEvent
import javafx.scene.input.Dragboard
import javafx.scene.input.MouseEvent
import javafx.scene.input.TransferMode
import javafx.scene.layout.Pane
import model.article.Article

/**
 * Created by Rob on 12/6/15.
 */
class DragAndDropController {

    public DragAndDropController(){

    }

    public void tempButtonClick(e, AuthoringController authoringController) {
        Article n = authoringController.getArticleFromCoordinates(e.getX(), e.getY());
        if (controlCheck(e)) {
            if (n != null) {
                ArticlePropertyEditorMenu popupEditingMenu =
                        new ArticlePropertyEditorMenu("Object Editor", n, this);
            }
        } else {
            Button b = (Button) e.getSource();
            Pane p = (Pane) b.getParent();
            p.getChildren().remove(b);
            authoringController.setHighlighted(false);
        }
    }

    public boolean controlCheck(e){
        return (e.isPopupTrigger() || e.isControlDown());
    }

    public void dragOn(event,AuthoringController authoringController){
        if (event.getGestureSource() != this &&
                event.getDragboard().hasImage()) {
            /* allow for moving */
            event.acceptTransferModes(TransferMode.MOVE);
        }

        event.consume();
    }


    public void dropElement(DragEvent event, AuthoringController authoringController){
        if(event.getGestureSource() instanceof HighlightedArticle){
            HighlightedArticle highlightedArticle = (HighlightedArticle) event.getGestureSource();
            double tempX = highlightedArticle.getLayoutX()+19.1;
            double tempY = highlightedArticle.getLayoutY()+15.1;
            Article n = authoringController.getArticleFromCoordinates(tempX,tempY);
            //System.out.println(n == null);
            n.setX((double)event.getX() + authoringController.getModelController().getViewpoint().getX()-27.5);
            n.setY((double)event.getY() + authoringController.getModelController().getViewpoint().getY()-27.5);
            Pane p = (Pane)highlightedArticle.getParent();
            p.getChildren().remove(highlightedArticle);
            authoringController.setHighlighted(false);
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

    public void addTemp(MouseEvent e, AuthoringController authoringController) {
        Article n = authoringController.getArticleFromCoordinates(e.getX(), e.getY());
        //high = n;
        ImageExtender dog = new ImageExtender();

        if (e.isPopupTrigger() || e.isControlDown()) {
            if (n != null) {
                ArticlePropertyEditorMenu popupEditingMenu = new ArticlePropertyEditorMenu("Object Editor", n, authoringController);
            }
        } else {
            try {
                double tX = n.getX() - authoringController.getModelController().getViewpoint().getX() -19;
                double tY = n.getY() - authoringController.getModelController().getViewpoint().getY() -15;
                HighlightedArticle highlightedArticle = new HighlightedArticle(dog.extendImage(n.getImageFile(),n.getWidth()), authoringController);
                authoringController.setHighlighted(true);
                authoringController.getUi().getDragAndDrop().getChildren().add(highlightedArticle);
                highlightedArticle.relocate(tX, tY);
            } catch (Exception exception) {
                System.out.println("hi");
            }
        }
    }

}
