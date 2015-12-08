package game.player;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import main.VoogaProperties;
import model.article.Article;

public class GamePlayerOverlay extends Pane {
	private LivesModule myLivesModule;
	private HealthModule myHealthModule;
	private ScoreModule myScoreModule;
	private HighScoresModule myHighScores;
	private ArrayList<HUDModule> myModules = new ArrayList<HUDModule>();
	private VoogaProperties props = new VoogaProperties();
	private Double OFFSET = props.getSceneWidth()/6.0;
	private double width = props.getSceneWidth() - OFFSET;
	private VBox container;

	public GamePlayerOverlay() {
		myScoreModule = new ScoreModule();
		myModules.add(myScoreModule);
		myHealthModule = new HealthModule();
		myModules.add(myHealthModule);
		myLivesModule = new LivesModule();
		myModules.add(myLivesModule);
		myHighScores = new HighScoresModule();
		myModules.add(myHighScores);
		init();
		this.getChildren().add(container);
		
	}

	private void init() {
		for(int i = 0; i<myModules.size();i++){
			myModules.get(i).init(OFFSET);
		}
		container = new VBox();
		container.setLayoutX(width);
		container.setPrefHeight(props.getSceneHeight()-OFFSET/2.6);
		container.setSpacing(20);
		container.setStyle("-fx-background-color: rgba(255,0,0,.5);" + "-fx-background-radius: 10px;");
		double padding = props.getSceneWidth()-container.getLayoutX()-myHealthModule.getWide();
		container.setPadding(new Insets(0,padding/2,0,padding/3));
		container.getChildren().addAll(myModules);
	}
	
	public void update(List<Article> arg, Article character) {
		try {
			for(HUDModule j:myModules){
				j.update(character);
			}
		} catch (NullPointerException e) {
		}
	}
}
