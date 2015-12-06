package authoring.backend

import model.article.Article;
import model.controller.ModelController

class ArticleEditor extends Editor {
  public ArticleEditor(ModelController mc){
    super(mc);
  }

  public Article createNewArticleAndPlace(String name,
      String imageFileName,
      Double x,
      Double y,
      Boolean direction) {
    double xAdjusted = x;
    double yAdjusted = y;
    return myModelController.createArticle(imageFileName, xAdjusted, yAdjusted,
        direction);
  }

  public void removeArticle(Article article) {
    myModelController.removeArticle(article);
  }

  public editProperty(String function,x, Article article) {
    article."$function"(x);
  }
}


