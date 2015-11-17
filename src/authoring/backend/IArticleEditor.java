package authoring.backend;

import java.util.List;
import javafx.scene.image.Image;
import model.Rule;


public interface IArticleEditor {

  public void createNewArticleAndPlace(String name,
                                       String imageFileName,
                                       Double x,
                                       Double y,
                                       Boolean direction);

  public void createNewArticle(String name, String imageFileName, Boolean direction);

  public void editArticleLocation(double x, double y);

  public void deleteObj();

  public void editArticleImage(String imageFileName);

  public void editArticleName(String name);

  public void editArticleImageDirection(boolean direction);

  public void editArticleImageBufferX(double x);
  
  public void editArticleImageBufferY(double y);
  
  public void editArticleXVelocity(double x);
  
  public void editArticleYVelocity(double y);
  
  public void editArticleOrientation(double value);
  
  public void addRuleToArticle(Rule rule);
  
  public void addRulesToArticle(List<Rule> rules);
  
  public void deleteRule(Rule rule);

  
  
}
