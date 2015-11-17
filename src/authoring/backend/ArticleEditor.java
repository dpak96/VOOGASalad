package authoring.backend;

import model.Article;

public class ArticleEditor implements IArticleEditor{
  private Article article;
  
  public ArticleEditor(){
    
  }

  public Article getArticle() {
    return article;
  }

  public void setArticle(Article article) {
    this.article = article;
  }
}
