package front.commands;

import javafx.scene.image.ImageView;
import model.Article;
import resourcemanager.ResourceManager;

public class ImageChange extends AbstractCommand {

	@Override
	public void update(Article article, ImageView front) {
		front.setImage(ResourceManager.getResourceManager().getIm().getImageMap().get(article.getImageFile()));
	}

}
