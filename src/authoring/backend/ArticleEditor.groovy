package authoring.backend

import model.article.Article;
import model.controller.ModelController

class ArticleEditor extends Editor {
	public ArticleEditor(ModelController mc){
		super(mc);
	}

	public Article createNewArticleAndPlace(String name,imageFileName,
			x,
			y, direction) {
		double xAdjusted = x;
		double yAdjusted = y;
		return myModelController.createArticleFromCenter(imageFileName, xAdjusted, yAdjusted,
				direction);
	}

	public void removeArticle(Article article) {
		myModelController.removeArticle(article);
	}

	public editProperty(String function,x, Article article) {
		article."$function"(x);
	}
}


