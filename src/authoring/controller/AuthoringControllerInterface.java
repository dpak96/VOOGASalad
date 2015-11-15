package authoring.controller;

import javafx.scene.Node;
import javafx.scene.image.Image;

/**
 * Created by Rob on 11/15/15.
 */
public interface AuthoringControllerInterface {

    public void setToolBar(String toolBar);

    public void selectFromToolBar();

    public void expandToolBar();

    public void createObj(String name);

    public void createObjAndPlace(double x,double y, String name);

    public void moveObj(double x, double y);

    public void deleteObj(Node n);

    public void editObj(Node n);

    public void setSplash(Image img);




    public void loadLevel();



}
