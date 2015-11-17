package authoring.backend;

import javafx.scene.image.Image;


public interface IArticleEditor {


  public void createNewArticle(String name);

  public void createObjAndPlace(double x, double y, String name);

  public void moveObj(double x, double y);

  public void deleteObj();

  public void editObj();

}
