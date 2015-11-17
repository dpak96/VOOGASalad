package authoring.controller;

import javafx.scene.Node;
import javafx.scene.image.Image;

/**
 * Created by Rob on 11/15/15.
 */
public interface IAuthoringController {

    public void setToolBar(String toolBar);

    public void selectFromToolBar();

    public void expandToolBar();

    public void createNewArticle(String name);

    public void createObjAndPlace(double x,double y, String name);

    public void moveObj(double x, double y);

    public void deleteObj();

    public void editObj();

    public void setSplash(Image img);

    public void loadLevel();
    
    public void editKeyPress();




}
