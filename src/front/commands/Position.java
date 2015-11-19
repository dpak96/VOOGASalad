package front.commands;

import javafx.scene.image.ImageView;
import model.Article;
import model.controller.ModelController;

public class Position extends AbstractCommand {

	@Override
	public void update(Article article, ModelController modelController, ImageView front) {
		front.setX(article.getX()-modelController.getViewpoint().getX());
		front.setY(article.getY()-modelController.getViewpoint().getY());
	}

}
