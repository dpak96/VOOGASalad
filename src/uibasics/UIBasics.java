package uibasics;

import model.Article;
import model.controller.ModelController;
import java.util.*;
import config.Config;
import front.commands.AbstractCommand;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class UIBasics{
  private Pane myPane;
  private List<Article> myBackArticles;
  private List<ImageView> myFrontArticles;
  private List<AbstractCommand> myCommands;
  private ModelController myModelController;

  public UIBasics(ModelController modelController) {
    load("commands");
    myPane = new Pane();
    myModelController = modelController;
    myBackArticles = new ArrayList<Article>();
    myFrontArticles = new ArrayList<ImageView>();
  }

  private void load(String identifier) {
    myCommands = new ArrayList<AbstractCommand>();
    String[] myVals =
        Config.getStringArray(String.format("%s.%s", this.getClass().getName(), identifier));
    for (String s : myVals) {
      myCommands.add(Config.getObject(s));
    }
    for (AbstractCommand c: myCommands) {
    	System.out.println(c);
    	System.out.println("bark");

    }
  }

  public Pane getPane() {
    return myPane;
  }

  public void update(List<Article> list, Article character) {
    clearAll();
    myBackArticles = list;
    for (Article value : myBackArticles) {
      articleUpdate(value);
    }
    articleUpdate(character);
    myPane.getChildren().addAll(myFrontArticles);
  }
  
  public void articleUpdate(Article article) {
	  ImageView img = new ImageView();
      commands(article, img);
      myFrontArticles.add(img);
  }

  private void commands(Article article, ImageView img) {
	  for (AbstractCommand c : myCommands)
		  c.update(article, myModelController, img);
  }
  
  private void clearAll() {
    myPane.getChildren().removeAll(myFrontArticles);
    myFrontArticles.clear();
  }

}
