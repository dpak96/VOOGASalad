package front.commands;
import javafx.scene.image.ImageView;
import model.article.Article;
import model.controller.ModelController;

public abstract class AbstractCommand {
	public abstract void update(Article article, ModelController modelController, ImageView front);
}
