package authoring.backend;

import model.Article;
import model.controller.ModelController;


public class ArticleEditor implements IArticleEditor {
  private Article article;
  private ModelController myModelController;

  public ArticleEditor(ModelController modelController) {
    myModelController = modelController;
  }

  public Article getArticle() {
    return article;
  }

  public void setArticle(Article article) {
    this.article = article;
  }

  @Override
  public void createNewArticleAndPlace(String name,
                                       String imageFileName,
                                       Double x,
                                       Double y,
                                       Boolean direction) {
    double xAdjusted = x + myModelController.getViewpoint().getX();
    double yAdjusted = y + myModelController.getViewpoint().getY();
    this.setArticle(myModelController.createArticle(imageFileName, xAdjusted, yAdjusted,
                                                    direction));
  }

  @Override
  public void createNewArticle(String name, String imageFileName, Boolean direction) {
    // TODO Auto-generated method stub

  }

  @Override
  public void editArticleLocation(double x, double y) {
    this.getArticle().setX(x);
    this.getArticle().setY(y);

  }

  @Override
  public void deleteObj() {
    myModelController.removeArticle(this.getArticle());
    this.setArticle(null);

  }

  @Override
  public void editArticleImage(String imageFileName) {
    this.getArticle().setImageFile(imageFileName);

  }

  @Override
  public void editArticleName(String name) {
    this.getArticle().setName(name);

  }

  @Override
  public void editArticleImageDirection(boolean direction) {
    this.getArticle().setDirection(direction);

  }

  @Override
  public void editArticleImageBufferX(double x) {
    this.getArticle().setXBuffer(x);

  }

  @Override
  public void editArticleImageBufferY(double y) {
    this.getArticle().setYBuffer(y);

  }

  @Override
  public void editArticleXVelocity(double x) {
    this.getArticle().setXVelocity(x);

  }

  @Override
  public void editArticleYVelocity(double y) {
    this.getArticle().setYVelocity(y);
  }

  @Override
  public void editArticleOrientation(double value) {
    this.getArticle().setOrientation(value);

  }
  
  //TODO: collisions

}
