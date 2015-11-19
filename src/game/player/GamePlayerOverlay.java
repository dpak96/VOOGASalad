package game.player;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import model.Article;
import properties.VoogaProperties;

public class GamePlayerOverlay extends BorderPane {
	private Text scoreText, healthText, lifeText;
	private Rectangle myPauser = new Rectangle(50,20,Color.BLUE);
	private final int OFFSET = 100;

	public GamePlayerOverlay() {
		setPrefSize(500, 500);
		VoogaProperties props = new VoogaProperties();
		double width = props.getSceneWidth() - OFFSET;
		scoreText = new Text("Score: ");
		healthText = new Text("Health :");
		lifeText = new Text("Life :");
		scoreText.setX(width);
		scoreText.setY(50);
		healthText.setX(width);
		healthText.setY(70);
		lifeText.setX(width);
		lifeText.setY(90);
		myPauser.setX(width);
		myPauser.setY(110);
		Text pause = new Text("Pause");
		pause.setX(width+5);
		pause.setY(125);
		
		
		this.getChildren().add(myPauser);
		this.getChildren().add(scoreText);
		this.getChildren().add(healthText);
		this.getChildren().add(lifeText);
		this.getChildren().add(pause);
		
	}
	
	public void update(List<Article> arg, Article character) {
		try {
			updateHealth(character.getHealth());
//			updateScore(character.getScore());
			updateLife(character.getLife());
		} catch (NullPointerException e) {
			System.out.println("No character yet");
			updateHealth(50);
			updateLife(60);
		}
	}

	private void updateScore(double score) {
		scoreText.setText("Score: " + score);
		
	}

	private void updateHealth(double health) {
		healthText.setText("Health: " + health);
	}
	
	private void updateLife(int life) {
		lifeText.setText("Life: " + life);
	}
	
	public Rectangle getPause(){
		return myPauser;
	}
}
