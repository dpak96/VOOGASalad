package authoring.controller;

import model.Article;

public class ArticleEditor {
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
