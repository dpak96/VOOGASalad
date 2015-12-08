package game.player;

import javafx.scene.layout.VBox;
import model.article.Article;

public abstract class HUDModule extends VBox {
	
	public HUDModule(){
		super();
	}
	
	public abstract void init(double offset);
	
	public abstract void update(Article character);
}
