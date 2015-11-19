package front.commands;

import javafx.scene.image.ImageView;
import model.Article;
import model.controller.ModelController;
import resourcemanager.ResourceManager;

public class ImageChange extends AbstractCommand {

	@Override
	public void update(Article article, ModelController modelController, ImageView front) {
		front.setImage(ResourceManager.getResourceManager().getIm().getImageMap().get(article.getImageFile()));
	}

}
