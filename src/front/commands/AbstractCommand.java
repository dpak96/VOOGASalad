package front.commands;
import javafx.scene.image.ImageView;
import model.article.Article;
import model.controller.ModelController;
import uibasics.IViewpoint;

//This entire class is part of my code masterpiece

public abstract class AbstractCommand {
	public abstract void update(Article article, IViewpoint viewpoint, ImageView front);
}
