package uibasics;

import main.GraphicHandler;
import model.Article;

import java.util.*;

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
	private UIStackPane myStackPane;
	
	public UIBasics() {
		//load("commands"); temporarily off
		myPane = new Pane();
		myPane.getChildren().add(new Rectangle(50, 50, 50, 50));
		myBackArticles = new HashMap<String, Article>();
		myFrontArticles = new ArrayList<ImageView>();
		authoringController = new AuthoringController();
		myStackPane = new UIStackPane();
		myStackPane.addPane(myPane);
		Authoring();
	}

	private void Authoring(){
		myStackPane.addPane(authoringController.getUi().tester());
	}

	private void load(String identifier) {
		myCommands = new ArrayList<AbstractCommand>();
		String[] myVals = Config.getStringArray(String.format("%s.%s", this.getClass().getName(), identifier));
		for(String s: myVals) {
			myCommands.add(Config.getObject(s));
		}	
	}


	public Pane getPane() {
		return myStackPane.getStack();
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
