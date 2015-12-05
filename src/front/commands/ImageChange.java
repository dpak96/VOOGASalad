package front.commands;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.article.Article;
import model.controller.ModelController;
import resourcemanager.ResourceManager;

public class ImageChange extends AbstractCommand {

	@Override
	public void update(Article article, ModelController modelController, ImageView front) {
		front.setImage((Image) ResourceManager.getResourceManager().getResource("ImageManager", article.getImageFile()));
	}

}
