package authoring.controller

import javafx.scene.control.Button
import javafx.scene.input.KeyCode
import javafx.scene.layout.Pane
import model.article.Article
import uibasics.KeyPress

/**
 * Created by Rob on 12/8/15.
 */
class KeyPressController {

    private AuthoringController authoringController;
    KeyPressController(AuthoringController authoring){
        authoringController = authoring;
        authoringController.getUi().getDragAndDrop().getScene().setOnKeyReleased({ event->  authoringController.callEvent("ArticleExtenderController","addTile",event)});
        authoringController.getUi().getDragAndDrop().getScene().setOnKeyPressed({ event->  pressButtons(event)});
    }

    private pressButtons(event){
        println("i")
        if(event.getCode() == KeyCode.D){
            println("hi")
            authoringController.callEvent("OtherController","deleteArticle",authoringController.getCurrentArticle());
        }
        Article view = authoringController.callEvent("OtherController", "getViewPoint")
        if(event.getCode() == KeyCode.RIGHT){
            view.setX(view.getX()+50);
            deleteButton();
        }
        if(event.getCode() == KeyCode.LEFT){
            view.setX(view.getX()-50);
            deleteButton();

        }
        if(event.getCode() == KeyCode.UP){
            view.setY(view.getY()-50);
            deleteButton();
        }
        if(event.getCode() == KeyCode.DOWN){
            view.setY(view.getY()+50);
            deleteButton();
        }

    }

    private deleteButton(){
        if(authoringController.getCurrentButton() != null){
            Button b = authoringController.getCurrentButton();
            Pane p = (Pane) b.getParent();
            p.getChildren().remove(b);
            authoringController.setHighlighted(false);
            authoringController.setCurrentButton(null);
        }
    }
}
