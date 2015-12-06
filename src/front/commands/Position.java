package front.commands;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.article.Article;
import model.controller.ModelController;
import resourcemanager.ResourceManager;

public class Position extends AbstractCommand {

	@Override
	public void update(Article article, ModelController modelController, ImageView front) {
		Image img = (Image) ResourceManager.getResourceManager().getResource("ImageManager", article.getImageFile());
		int iSizeX = (int) (article.getWidth()/img.getWidth());
		for (int i = 0; i < iSizeX; i++) {
			front.setX(article.getX()/*-modelController.getViewpoint().getX()+(i*img.getWidth())*/);
			front.setY(article.getY()/*-modelController.getViewpoint().getY()*/);
		}
	}

}
