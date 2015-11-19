package game.player;

import java.util.ArrayList;

import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import model.Article;

public class GamePlayerOverlay extends BorderPane {
	public GamePlayerOverlay() {
		setPrefSize(500, 500);
		this.getChildren().add(new Rectangle(50,50,50,50));
	}
	
	public void update(ArrayList<Article> arg) {
	
	}
}
