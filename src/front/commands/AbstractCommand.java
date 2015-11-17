package front.commands;
import javafx.scene.image.ImageView;
import model.Article;

public abstract class AbstractCommand {
	public abstract void update(Article article, ImageView front);
}
