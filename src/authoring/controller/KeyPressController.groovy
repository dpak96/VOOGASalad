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

    private AuthoringController myAuthoringController;
    KeyPressController(AuthoringController authoring){
        myAuthoringController = authoring;
        myAuthoringController.getUi().getDragAndDrop().getScene().setOnKeyReleased({ event->  myAuthoringController.callEvent("ArticleExtenderController","addTile",event)});
        myAuthoringController.getUi().getDragAndDrop().getScene().setOnKeyPressed({ event->  pressButtons(event)});
    }

    private pressButtons(event){
        println("i")
        if(event.getCode() == KeyCode.P){
            println("hi")
            myAuthoringController.callEvent("OtherController","deleteArticle",myAuthoringController.getCurrentArticle());
        }
        Article view = myAuthoringController.callEvent("OtherController", "getViewPoint")
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
        if(myAuthoringController.getCurrentButton() != null){
            Button b = myAuthoringController.getCurrentButton();
            Pane p = (Pane) b.getParent();
            p.getChildren().remove(b);
            myAuthoringController.setHighlighted(false);
            myAuthoringController.setCurrentButton(null);
        }
    }
}
