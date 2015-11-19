package uibasics;

import model.Article;
import resourcemanager.ResourceManager;
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

  public UIBasics() {
    load("commands");
    myPane = new Pane();
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

  public void update(List<Article> list) {
    clearAll();
    myBackArticles = list;
    for (Article value : myBackArticles) {
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
    for (AbstractCommand c : myCommands)
      c.update(article, img);
//    img.setImage(ResourceManager.getResourceManager().getIm().getImageMap().get(article.getImageFile()));
//    System.out.print("hi");
//    img.setX(article.getX());
//    img.setY(article.getY());
//    img.setRotate(article.getOrientation());
  }

}
