package authoring.backend;

import java.util.List;
import javafx.scene.image.Image;
import model.Article;


public interface IArticleEditor {

  public Article createNewArticleAndPlace(String name,
                                       String imageFileName,
                                       Double x,
                                       Double y,
                                       Boolean direction);

  public void editArticleLocation(double x, double y, Article article);

  public void deleteObj(Article article);

  public void editArticleImage(String imageFileName, Article article);

  public void editArticleName(String name, Article article);

  public void editArticleImageDirection(boolean direction, Article article);

  public void editArticleImageBufferX(double x, Article article);
  
  public void editArticleImageBufferY(double y, Article article);
  
  public void editArticleXVelocity(double x, Article article);
  
  public void editArticleYVelocity(double y, Article article);
  
  public void editArticleOrientation(double value, Article article);
  


  
  
}
