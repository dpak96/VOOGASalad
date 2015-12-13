// This entire file is part of my masterpiece
// Kevin Wang

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
		return myModelController.createArticleFromCenter(imageFileName, x, y,
				direction);
	}

	public void removeArticle(Article article) {
		myModelController.removeArticle(article);
	}

	public editProperty(String function,x, Article article) {
		article."$function"(x);
	}
}


