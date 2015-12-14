package front.commands;

import javafx.scene.image.ImageView;
import model.article.Article;
import model.controller.ModelController;
import uibasics.IViewpoint;

//This entire class is part of my code masterpiece

public class Rotation extends AbstractCommand {

	@Override
	public void update(Article article, IViewpoint modelController, ImageView front) {
		front.setRotate(article.getOrientation());
	}

}
