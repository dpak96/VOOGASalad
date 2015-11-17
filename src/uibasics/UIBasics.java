package uibasics;

import model.Article;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
<<<<<<< HEAD
=======

>>>>>>> cd8b0d953ccbbf180cb81efc07db2508dc406650
import authoring.controller.AuthoringController;
import config.Config;
import front.commands.AbstractCommand;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class UIBasics implements Observer {
	private Pane myPane;
	private HashMap<String, Article> myBackArticles;
	private List<ImageView> myFrontArticles;
	private List<AbstractCommand> myCommands;
	private AuthoringController authoringController;
	
	public UIBasics() {
		load("commands");
		myPane = new Pane();
		myPane.getChildren().add(new Rectangle(50, 50, 50, 50));
		myBackArticles = new HashMap<String, Article>();
		myFrontArticles = new ArrayList<ImageView>();
	}
	
	private void load(String identifier) {
		myCommands = new ArrayList<AbstractCommand>();
		String[] myVals = Config.getStringArray(String.format("%s.%s", this.getClass().getName(), identifier));
		for(String s: myVals) {
			myCommands.add(Config.getObject(s));
		}	
	}
	
	public Pane getPane() {
		return myPane;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object arg) {
		clearAll();
		myBackArticles = ((HashMap<String, Article>) arg);
		for (Article value: myBackArticles.values()) {
			ImageView img = new ImageView();
			articleUpdate(value, img);
			myFrontArticles.add(img);
		}
		myPane.getChildren().addAll(myFrontArticles);
	}	
	
	private void clearAll() {
		myPane.getChildren().removeAll(myFrontArticles);
		myFrontArticles.clear();
	}
	
	public void articleUpdate(Article article, ImageView img) {
		for (AbstractCommand c: myCommands)
			c.update(article, img);
	}

  public AuthoringController getAuthoringController() {
    return authoringController;
  }

  public void setAuthoringController(AuthoringController authoringController) {
    this.authoringController = authoringController;
  }
	
}
