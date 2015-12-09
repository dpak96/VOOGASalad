package authoring.controller

import javafx.scene.input.KeyCode
import javafx.scene.input.KeyEvent
import model.article.Article
import uibasics.KeyPress

/**
 * Created by Rob on 12/6/15.
 */
class ArticleExtenderController {
    private double myNewXRight, myNewYRight;
    private double myInitWidth;
    private Article myCurrent = null;
    private AuthoringController myAuthoringController;
    private myLeft,myRight;


    public ArticleExtenderController(AuthoringController authoring){
        myAuthoringController = authoring;
        myAuthoringController.getUi().getDragAndDrop().getScene().setOnKeyReleased({ event->  addTile(event)});
        setKeys();
        myAuthoringController.setHighlighted(false);
        //authoringController.callEvent("DragAndDropController",)
    }

    private setKeys(){
        myLeft = KeyCode.N;
        myRight = KeyCode.M;
    }

    public void addTile(KeyEvent event) {
        updateArticle(event);
        buttonCheckAndExtend(event);
    }

    private updateArticle(event){
        if(!myAuthoringController.getCurrentArticle().equals(myCurrent)){
            myCurrent = myAuthoringController.getCurrentArticle();
            myInitWidth = myCurrent.getWidth();
            initRightAndLeft(event);
        }
    }

    private initRightAndLeft(event){
        myNewXRight = myCurrent.getX() + (myCurrent.getWidth() / 2)+myAuthoringController.getModelController().getViewpoint().getX();
        myNewYRight = myCurrent.getX() +myAuthoringController.getModelController().getViewpoint().getX();
    }

    private buttonCheckAndExtend(event){
        if (checkClick(event,myRight)) {
            extend();
        }
        if (checkClick(event,myLeft)){
            myNewYRight -= myInitWidth;
            extend();
            myCurrent.setX(myNewYRight);
        }

    }

    private checkClick(event,input){
        return (event.getCode() == input && event.isControlDown());
    }

    private extend(){
        try {
            myCurrent.setWidth(myCurrent.getWidth()+myInitWidth);
        }
        catch (Exception e){

        }
    }











}
