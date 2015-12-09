package authoring.controller

import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import model.article.Article
import uibasics.KeyPress

/**
 * Created by Rob on 12/6/15.
 */
class ArticleExtenderController {
    private double newXRight, newXLeft;
    private double initWith;
    private Article current = null;
    private AuthoringController authoringController;
    private left,right;


    public ArticleExtenderController(AuthoringController authoring){
        authoringController = authoring;
        authoringController.getUi().getDragAndDrop().getScene().setOnKeyReleased({ event->  addTile(event)});
        setKeys();
        authoringController.setHighlighted(false);
        //authoringController.callEvent("DragAndDropController",)
    }

    private setKeys(){
        left = KeyCode.N;
        right = KeyCode.M;
    }

    public void addTile(KeyEvent event) {
        updateArticle(event);
        buttonCheckAndExtend(event);
    }

    private updateArticle(event){
        if(!authoringController.getCurrentArticle().equals(current)){
            current = authoringController.getCurrentArticle();
            initWith = current.getWidth();
            initRightAndLeft(event);
        }
    }

    private initRightAndLeft(event){
        newXRight = current.getX() + (current.getWidth() / 2)+authoringController.getModelController().getViewpoint().getX();
        newXLeft = current.getX() +authoringController.getModelController().getViewpoint().getX();
    }

    private buttonCheckAndExtend(event){
        if (checkClick(event,right)) {
            extend();
        }
        if (checkClick(event,left)){
            newXLeft -= initWith;
            extend();
            current.setX(newXLeft);
        }

    }

    private checkClick(event,input){
        return (event.getCode() == input && event.isControlDown());
    }

    private extend(){
        try {
            current.setWidth(current.getWidth()+initWith);
        }
        catch (Exception e){

        }
    }











}
