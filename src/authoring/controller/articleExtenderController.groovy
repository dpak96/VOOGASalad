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


    public ArticleExtenderController(authoring){
        authoringController = authoring;
        authoringController.getUi().getDragAndDrop().getScene().setOnKeyReleased({ event->  addTile(event,authoringController)});
        setKeys();
    }

    private setKeys(){
        left = KeyCode.N;
        right = KeyCode.M;
    }

    public void addTile(KeyEvent event) {
        updateArticle(event);
        initRightAndLeft(event);
        buttonCheckAndExtend();
    }

    private updateArticle(event){
        if(authoringController.getCurrentArticle() != current){
            current = authoringController.getCurrentArticle();
            initWith = current.getWidth();
        }
    }

    private initRightAndLeft(event){
        if (newXRight == 0) {
            newXRight = current.getX() + (current.getWidth() / 2)+authoringController.getModelController().getViewpoint().getX();
        }
        if(newXLeft == 0){
            newXLeft = current.getX() +authoringController.getModelController().getViewpoint().getX();
        }
    }

    private buttonCheckAndExtend(event){
        if (checkClick(right)) {
            extend();
        }
        else(checkClick(left)){
            newXLeft -= current.getwidth();
            extend();
        }

    }

    private whichClick(input){
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
