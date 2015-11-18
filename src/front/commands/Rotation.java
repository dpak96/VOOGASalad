package front.commands;

import javafx.scene.image.ImageView;
import model.Article;

public class Rotation extends AbstractCommand {

	@Override
	public void update(Article article, ImageView front) {
		front.setRotate(article.getOrientation());
	}

}