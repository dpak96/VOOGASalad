package authoring.backend;

import model.Article;
import model.controller.ModelController;


public class ArticleEditor implements IArticleEditor {
  private ModelController myModelController;

  public ArticleEditor(ModelController modelController) {
    myModelController = modelController;
  }

  @Override
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

  @Override
  public void editArticleLocation(double x, double y, Article article) {
    article.setX(x);
    article.setY(y);

  }

  @Override
  public void deleteObj(Article article) {
    myModelController.removeArticle(article);

  }

  @Override
  public void editArticleImage(String imageFileName, Article article) {
    article.setImageFile(imageFileName);

  }

  @Override
  public void editArticleName(String name, Article article) {
    article.setName(name);

  }

  @Override
  public void editArticleImageDirection(boolean direction, Article article) {
    article.setDirection(direction);

  }

  @Override
  public void editArticleImageBufferX(double x, Article article) {
    article.setXBuffer(x);

  }

  @Override
  public void editArticleImageBufferY(double y, Article article) {
    article.setYBuffer(y);

  }

  @Override
  public void editArticleXVelocity(double x, Article article) {
    article.setXVelocity(x);

  }

  @Override
  public void editArticleYVelocity(double y, Article article) {
    article.setYVelocity(y);
  }

  @Override
  public void editArticleOrientation(double value, Article article) {
    article.setOrientation(value);

  }

  // TODO: collisions

}
