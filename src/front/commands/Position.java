package front.commands;

import javafx.scene.image.ImageView;
import model.Article;

public class Position extends AbstractCommand {

	@Override
	public void update(Article article, ImageView front) {
		front.setX(article.getX());
		front.setY(article.getY());
	}

}
