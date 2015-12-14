package front.commands;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.article.Article;
import model.controller.ModelController;
import resourcemanager.ResourceManager;
import uibasics.IViewpoint;

//This entire class is part of my code masterpiece

public class ImageChange extends AbstractCommand {

	@Override
	public void update(Article article, IViewpoint modelController, ImageView front) {
		front.setImage((Image) ResourceManager.getResourceManager().getResource("ImageManager", article.getImageFile()));
	}

}
