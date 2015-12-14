package front.commands;

import javafx.scene.image.ImageView;
import model.article.Article;
import uibasics.IViewpoint;

//This entire class is part of my code masterpiece

public class Opacity extends AbstractCommand {

	@Override
	public void update(Article article, IViewpoint viewpoint, ImageView front) {
		front.setOpacity(value.getOpacity());
	}
	
	

}
