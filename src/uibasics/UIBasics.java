package uibasics;

import model.article.Article;
import model.controller.ModelController;
import resourcemanager.ResourceManager;

import java.util.*;

import config.Config;
import front.commands.AbstractCommand;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;

//This entire class is part of my code masterpiece

public class UIBasics {
  private Pane myPane;
  private List<Article> myBackArticles;
  private List<ImageView> myFrontArticles;
  private List<AbstractCommand> myCommands;
  private IViewpoint myViewpoint;
  private String ImageManager;
  private boolean myWidthAsPercent, myHeightAsPercent, myContain, myCover;

  public UIBasics(IViewpoint viewpoint) {
    myPane = new Pane();
    myViewpoint = viewpoint;
    myBackArticles = new ArrayList<Article>();
    myFrontArticles = new ArrayList<ImageView>();
    init();
  }
  
  private void init() {
	    load("commands");
	    ImageManager = "ImageManager";
	    myWidthAsPercent = true;
	    myHeightAsPercent = true;
	    myContain = true;
	    myCover = false;
  }

  private void load(String identifier) {
    myCommands = new ArrayList<AbstractCommand>();
    String[] myVals =
        Config.getStringArray(String.format("%s.%s", this.getClass().getName(), identifier));
    for (String s : myVals) {
      myCommands.add(Config.getObject(s));
    }
  }

  public Pane getPane() {
    return myPane;
  }

  public void update(List<Article> list, Article character, String backImage) {
    clearAll();
    myBackArticles = list;
    list.add(character);
    for (Article value : myBackArticles) {
		articleUpdate(value);
    }
    myPane.getChildren().addAll(myFrontArticles);
    setBackImage(backImage);
  }

  private void articleUpdate(Article article) {
    ImageView img = new ImageView();
    commands(article, img);
    myFrontArticles.add(img);
  }

  private void commands(Article article, ImageView img) {
    for (AbstractCommand c : myCommands)
      c.update(article, myViewpoint, img);
  }

  private void clearAll() {
    myPane.getChildren().removeAll(myFrontArticles);
    myFrontArticles.clear();
  }

  private void setBackImage(String img) {
	try {
	    BackgroundSize size = new BackgroundSize(100, 100, myWidthAsPercent, myHeightAsPercent, myContain, myCover);
	    BackgroundPosition pos = new BackgroundPosition(null, -myViewpoint.getViewpoint().getX(), 
	    		false, null, myViewpoint.getViewpoint().getY(), false);
	    BackgroundImage back =
	        new BackgroundImage((Image) resourcemanager.ResourceManager.getResourceManager()
	            .getResource(ImageManager, img),
	                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, pos, size);

	    myPane.setBackground(new Background(back));
	} catch (NullPointerException e) {
	    myPane.setBackground(null);
	}
  }

}
