package authoring.controller

import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import model.article.Article

/**
 * Created by Rob on 12/6/15.
 */
class ArticleExtenderController {

    public ArticleExtenderController(){}

    public void init(AuthoringController authoringController){
        authoringController.getUi().getDragAndDrop().getScene().setOnKeyReleased({ event->  addTile(event)});
    }

    public void addTile(KeyEvent event, AuthoringController authoringController) {
        if (event.getCode() == KeyCode.B && event.isControlDown()) {
            Article current = authoringController.getCurrentArticle();
            if (nXRight == 0) {
                nXRight = current.getX() + (current.getWidth() / 2);
            }
            try {
                //currentArticle.setWidth(currentArticle.getWidth()*2);
            }
            catch (Exception e){

            }
        }
        if (event.getCode() == KeyCode.V && event.isControlDown()) {

            if (nXLeft == 0) {
                nXLeft = current.getX() - (current.getWidth() / 2)+authoringController.getModelController().getViewpoint().getX();
            }
            try {
                nXLeft -= current.getWidth();
                current.setWidth(current.getWidth()*2);
                current.setX(nXLeft);

            } catch (Exception e) {
            }
        }
    }
}
