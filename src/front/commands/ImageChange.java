package front.commands;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.Article;

public class ImageChange extends AbstractCommand {

	@Override
	public void update(Article article, ImageView front) {
		Image img = new Image(getClass().getClassLoader().getResourceAsStream(article.getImageFile()));
		front.setImage(img);
	}

}
