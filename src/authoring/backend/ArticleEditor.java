package authoring.backend;

import model.Article;
import model.controller.ModelController;


public class ArticleEditor {
  private ModelController myModelController;

  public ArticleEditor(ModelController modelController) {
    myModelController = modelController;
  }

  public Article createNewArticleAndPlace(String name,
                                          String imageFileName,
                                          Double x,
                                          Double y,
                                          Boolean direction) {
    double xAdjusted = x + myModelController.getViewpoint().getX();
    double yAdjusted = y + myModelController.getViewpoint().getY();
    return myModelController.createArticle(imageFileName, xAdjusted, yAdjusted,
                                           direction);
  }

  public void editArticleLocation(double x, double y, Article article) {
    article.setX(x);
    article.setY(y);

  }

  public void deleteObj(Article article) {
    myModelController.removeArticle(article);

  }

  public void editArticleImage(String imageFileName, Article article) {
    article.setImageFile(imageFileName);

  }

  public void editArticleName(String name, Article article) {
    article.setName(name);

  }

  public void editArticleImageDirection(boolean direction, Article article) {
    article.setDirection(direction);

  }

  public void editArticleImageBufferX(double x, Article article) {
    article.setXBuffer(x);

  }

  public void editArticleImageBufferY(double y, Article article) {
    article.setYBuffer(y);

  }

  public void editArticleXVelocity(double x, Article article) {
    article.setXVelocity(x);

  }

  public void editArticleYVelocity(double y, Article article) {
    article.setYVelocity(y);
  }

  public void editArticleOrientation(double value, Article article) {
    article.setOrientation(value);

  }

  // TODO: collisions

}
