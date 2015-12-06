package authoring.controller

import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import model.article.Article

/**
 * Created by Rob on 12/6/15.
 */
class ArticleExtenderController {
    private double nXRight, nXLeft;
    private double initWith;
    private Article current = null;
    public ArticleExtenderController(){}

    public void init(AuthoringController authoringController){

        authoringController.getUi().getDragAndDrop().getScene().setOnKeyReleased({ event->  addTile(event,authoringController)});
    }

    public void addTile(KeyEvent event, AuthoringController authoringController) {
        if(authoringController.getCurrentArticle() != current){
            current = authoringController.getCurrentArticle();
            initWith = current.getWidth();
            nXRight =0;
            nXLeft = 0;
        }
        if (event.getCode() == KeyCode.B && event.isControlDown()) {
            if (nXRight == 0) {
                nXRight = current.getX() + (current.getWidth() / 2)+authoringController.getModelController().getViewpoint().getX();
            }
            try {
                current.setWidth(current.getWidth()+initWith);
            }
            catch (Exception e){

            }
        }
        if (event.getCode() == KeyCode.V && event.isControlDown()) {
            if(nXLeft == 0){
                nXLeft = current.getX() +authoringController.getModelController().getViewpoint().getX();
            
            }

            try {
                nXLeft -= initWith;
                current.setWidth(current.getWidth()+initWith);
                current.setX(nXLeft);

            } catch (Exception e) {

            }
        }
    }
}
