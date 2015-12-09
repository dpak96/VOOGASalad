package authoring.controller

import authoring.ui.draganddrop.DraggableElement
import authoring.ui.draganddrop.HighlightedArticle
import authoring.ui.editingmenus.ArticlePropertyEditorMenu
import imageeditor.ImageExtender
import javafx.scene.control.Button
import javafx.scene.input.DragEvent
import javafx.scene.input.Dragboard
import javafx.scene.input.MouseEvent
import javafx.scene.input.TransferMode
import javafx.scene.layout.Pane
import model.article.Article

class DragAndDropController {
    private myAuthoringController;
    private double myBorderWidth = 4;

    public DragAndDropController(AuthoringController authoring){
        myAuthoringController = authoring;
    }

    public void tempButtonClick(e) {
        HighlightedArticle button = (HighlightedArticle)e.getSource();
        Article n = myAuthoringController.callEvent("OtherController","getArticleFromCoordinates",button.getLayoutX()+myBorderWidth +0.1, button.getLayoutY()+myBorderWidth+0.01);

        if (controlCheck(e)) {
            if (n != null) {
                ArticlePropertyEditorMenu popupEditingMenu =
                        new ArticlePropertyEditorMenu("Object Editor", n, myAuthoringController);
            }
        } else {
            removeButton(e,n);
        }
    }

    public boolean controlCheck(e){
        return (e.isPopupTrigger() || e.isControlDown());
    }

    public void dragOn(event){
        if (event.getGestureSource() != this &&
                event.getDragboard().hasImage()) {
            /* allow for moving */
            event.acceptTransferModes(TransferMode.MOVE);
        }

        event.consume();
    }

    public removeButton(e,n){
        if(e.getSource() instanceof HighlightedArticle){
            if(n != null){
                n.setActive();
            }
            Button b = (Button) e.getSource();
            Pane p = (Pane) b.getParent();
            p.getChildren().remove(b);
            myAuthoringController.setHighlighted(false);
        }
    }


    public void dropElement(event){
        println("WHAT ON EARTH");
        if(event.getGestureSource() instanceof HighlightedArticle){
            HighlightedArticle highlightedArticle = (HighlightedArticle) event.getGestureSource();
            double tempX = highlightedArticle.getLayoutX()+myBorderWidth +0.1;
            double tempY = highlightedArticle.getLayoutY()+myBorderWidth +0.1;
            Article n = myAuthoringController.callEvent("OtherController","getArticleFromCoordinates",tempX,tempY);
            n.setX((double)event.getX() + myAuthoringController.getModelController().getViewpoint().getX()-(n.getWidth()/2));
            n.setY((double)event.getY() + myAuthoringController.getModelController().getViewpoint().getY()-(n.getHeight()/2));
            n.setActive();
            Pane p = (Pane)highlightedArticle.getParent();
            p.getChildren().remove(highlightedArticle);
            myAuthoringController.setHighlighted(false);
        }
        else {
            myAuthoringController.callEvent("ArticleCAndGController","createAndPlaceArticle",event);
        }
        Dragboard db = event.getDragboard();
        boolean success = false;
        if (db.hasImage()) {
            success = true;
        }
        event.setDropCompleted(success);
        event.consume();
    }

    public void addTemp(e) {
        Article n = myAuthoringController.callEvent("OtherController","getArticleFromCoordinates",e.getX(), e.getY());
        myAuthoringController.setCurrentArticle(n);
        myAuthoringController.setHighlighted(true);
        ImageExtender dog = new ImageExtender();
        if (e.isPopupTrigger() || e.isControlDown()) {
            if (n != null) {
                ArticlePropertyEditorMenu popupEditingMenu = new ArticlePropertyEditorMenu("Object Editor", n, myAuthoringController);
            }
        }
        else {
            try {
                n.setHardInactive();
                double tX = n.getX() - myAuthoringController.getModelController().getViewpoint().getX() -myBorderWidth;
                double tY = n.getY() - myAuthoringController.getModelController().getViewpoint().getY() -myBorderWidth;
                HighlightedArticle highlightedArticle = new HighlightedArticle(dog.extendImage(n.getImageFile(),n.getWidth(),n.getHeight()), myAuthoringController);
                myAuthoringController.setHighlighted(true);
                myAuthoringController.getUi().getDragAndDrop().getChildren().add(highlightedArticle);
                highlightedArticle.relocate(tX, tY);
                myAuthoringController.setCurrentButton(highlightedArticle);
            } catch (Exception exception) {
                System.out.println("hip");
            }
        }
    }



}
