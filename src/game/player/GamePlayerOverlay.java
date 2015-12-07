package game.player;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import main.VoogaProperties;
import model.article.Article;
import resourcemanager.ResourceManager;

public class GamePlayerOverlay extends Pane {
	private LivesModule myLivesModule;
	private HealthModule myHealthModule;
	private ScoreModule myScoreModule;
	private VoogaProperties props = new VoogaProperties();
	private Double OFFSET = props.getSceneWidth()/6.0;
	private double width = props.getSceneWidth() - OFFSET;
	private VBox container;

	public GamePlayerOverlay() {
		myScoreModule = new ScoreModule();
		myScoreModule.initScore(OFFSET);
		myHealthModule = new HealthModule();
		myHealthModule.init(OFFSET);
		myLivesModule = new LivesModule();
		myLivesModule.init(myHealthModule.getWide());
		init();
		container.getChildren().addAll(myScoreModule,myHealthModule,myLivesModule);
		this.getChildren().add(container);
		
	}

	private void init() {
		container = new VBox();
		container.setLayoutX(width);
		container.setPrefHeight(props.getSceneHeight()-OFFSET);
		container.setSpacing(20);
		container.setStyle("-fx-background-color: rgba(255,0,0,.5);" + "-fx-background-radius: 10px;");
		double padding = props.getSceneWidth()-container.getLayoutX()-myHealthModule.getWide();
		container.setPadding(new Insets(0,padding/2,0,padding/3));
	}
	
	public void update(List<Article> arg, Article character) {
		try {
			updateHealth(character.getHealth());
			updateScore(character.getScore());
			updateLife(character.getLife(), character);
		} catch (NullPointerException e) {
			System.out.println("No character yet");
		}
	}

	private void updateScore(double score) {
		myScoreModule.update(score);
	}

	private void updateHealth(double health) {
		myHealthModule.update(health);
	}
	
	private void updateLife(int life, Article character) {
		myLivesModule.update(life, character);
	}
}
