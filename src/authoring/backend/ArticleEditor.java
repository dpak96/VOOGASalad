package authoring.backend;

import java.util.List;
import model.Article;


public class ArticleEditor implements IArticleEditor {
  private Article article;

  public ArticleEditor() {

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

  }

  @Override
  public void createNewArticle(String name, String imageFileName, Boolean direction) {
    // TODO Auto-generated method stub

  }

  @Override
  public void editArticleLocation(double x, double y) {
    // TODO Auto-generated method stub

  }

  @Override
  public void deleteObj() {
    // TODO Auto-generated method stub

  }

  @Override
  public void editArticleImage(String imageFileName) {
    // TODO Auto-generated method stub

  }

  @Override
  public void editArticleName(String name) {
    // TODO Auto-generated method stub

  }

  @Override
  public void editArticleImageDirection(boolean direction) {
    // TODO Auto-generated method stub

  }

  @Override
  public void editArticleImageBufferX(double x) {
    // TODO Auto-generated method stub

  }

  @Override
  public void editArticleImageBufferY(double y) {
    // TODO Auto-generated method stub

  }

  @Override
  public void editArticleXVelocity(double x) {
    // TODO Auto-generated method stub

  }

  @Override
  public void editArticleYVelocity(double y) {
    // TODO Auto-generated method stub

  }

  @Override
  public void editArticleOrientation(double value) {
    // TODO Auto-generated method stub

  }

}
