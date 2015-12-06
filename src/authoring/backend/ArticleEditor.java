package authoring.backend;

import model.article.Article;
import model.controller.ModelController;


public class ArticleEditor extends Editor{
  //private PropertyEditor pe;
  
  public ArticleEditor(ModelController modelController) {
    super(modelController);
    //pe = new PropertyEditor();
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

  public void removeArticle(Article article) {
    myModelController.removeArticle(article);

  }
  
  public void edit(String thing, Object edit, Article article){
    //pe.editProperty(thing,edit,article);
  }

 

  // TODO: collisions

}
