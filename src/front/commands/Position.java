package front.commands;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.article.Article;
import model.controller.ModelController;
import resourcemanager.ResourceManager;
import uibasics.IViewpoint;

//This entire class is part of my code masterpiece

public class Position extends AbstractCommand {

	@Override
	public void update(Article article, IViewpoint viewpoint, ImageView front) {
//		Image img = (Image) ResourceManager.getResourceManager().getResource("ImageManager", article.getImageFile());
//		int iSizeX = (int) (article.getWidth()/img.getWidth());
//		for (int i = 0; i < iSizeX; i++) {
			front.setX(article.getX()-viewpoint.getViewpoint().getX()/*+(i*img.getWidth())*/);
			front.setY(article.getY()-viewpoint.getViewpoint().getY());
//		}
	}

}
