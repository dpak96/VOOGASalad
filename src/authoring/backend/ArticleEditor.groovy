// This entire file is part of my masterpiece.
// Rob Martorano

package authoring.backend

import model.article.Article;
import model.controller.ModelController

class ArticleEditor extends Editor {
	public ArticleEditor(ModelController mc){
		super(mc);
	}

	protected createNewArticleAndPlace(String imageFileName, double x, double y, boolean direction) {
		 myModelController.createArticleFromCenter(imageFileName, x, y, direction);
	}

	protected getArticle(double x, double y){
		return myModelController.getArticleFromCoordinates(x,y);
	}

	protected void removeArticle(Article article) {
		myModelController.removeArticle(article);
	}


	protected editProperty(String function,x, Article article) {
		article."$function"(x);
	}





}


