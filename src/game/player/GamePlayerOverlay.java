// This entire file is part of my masterpiece.
// Alex Rice
package game.player;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import action.controller.ActionController;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import main.VoogaProperties;
import model.article.Article;

public class GamePlayerOverlay extends Pane {
	private LivesModule myLivesModule;
	private HealthModule myHealthModule;
	private ScoreModule myScoreModule;
	private HighScoresModule myHighScores;
	private MapOverviewModule myMapModule;
	private ArrayList<IHUDModule> myModules = new ArrayList<IHUDModule>();
	private final VoogaProperties PROPS = new VoogaProperties();
	private final Double OFFSET = PROPS.getSceneWidth()/6.0;
	private final double WIDTH = PROPS.getSceneWidth() - OFFSET;
	private VBox myContainer;

	public GamePlayerOverlay(String name) throws IOException, ParserConfigurationException, SAXException {
		myScoreModule = new ScoreModule();
		myModules.add(myScoreModule);
		myHealthModule = new HealthModule();
		myModules.add(myHealthModule);
		myLivesModule = new LivesModule();
		myModules.add(myLivesModule);
		myMapModule = new MapOverviewModule();
		myModules.add(myMapModule);
		init();
		this.getChildren().add(myContainer);
		
	}

	private void init() throws IOException, ParserConfigurationException, SAXException {
		for(int i = 0; i<myModules.size();i++){
			myModules.get(i).init(OFFSET);
		}
		myContainer = new VBox();
		myContainer.setLayoutX(WIDTH);
		myContainer.setPrefHeight(PROPS.getSceneHeight()-OFFSET/2.6);
		myContainer.setSpacing(20);
		myContainer.setStyle("-fx-background-color: rgba(255,0,0,.5);" + "-fx-background-radius: 10px;");
		double padding = PROPS.getSceneWidth()-myContainer.getLayoutX()-myHealthModule.getWide();
		myContainer.setPadding(new Insets(0,padding/2,0,padding/3));
		for(int i = 0; i<myModules.size();i++){
			myContainer.getChildren().add((Node) myModules.get(i));
		}
	}
	
	public void update(List<Article> arg, Article character, ActionController ac) {
		try {
			for(IHUDModule j:myModules){
				j.update(arg, character, ac);
			}
		} catch (NullPointerException e) {
		}
	}
	
	public void setName(String name) throws IOException, ParserConfigurationException, SAXException{
		try{
		myContainer.getChildren().remove(4);
		}catch(Exception e){
		}
		myHighScores = new HighScoresModule(name);
		myModules.add(myHighScores);
		myHighScores.init(OFFSET);
		myContainer.getChildren().add(myHighScores);
	}
}
