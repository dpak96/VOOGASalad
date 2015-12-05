package front.commands;

import javafx.scene.image.ImageView;
import model.article.Article;
import model.controller.ModelController;

public class Rotation extends AbstractCommand {

	@Override
	public void update(Article article, ModelController modelController, ImageView front) {
		front.setRotate(article.getOrientation());
	}

}
