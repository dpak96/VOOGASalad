package game.player;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Article;
import properties.VoogaProperties;

public class GamePlayerOverlay extends BorderPane {
	private Text scoreText;
	private Text healthText;

	public GamePlayerOverlay() {
		setPrefSize(500, 500);
		VoogaProperties props = new VoogaProperties();
		
		this.getChildren().add(new Rectangle(50,50,50,50));
		scoreText = new Text();
		healthText = new Text();
		scoreText.setX(props.getSceneWidth() - 50);
		scoreText.setY(50);
		healthText.setX(props.getSceneWidth() - 50);
		healthText.setY(60);
		
		this.getChildren().add(scoreText);
		this.getChildren().add(healthText);
		
		
	}
	
	public void update(List<Article> arg, Article character) {
//		updateScore();
		updateHealth(character.getHealth());
	}

	private void updateScore(double score) {
		scoreText.setText("Score: " + score);
		
	}

	private void updateHealth(double health) {
		healthText.setText("Health: " + health);
	}
}
