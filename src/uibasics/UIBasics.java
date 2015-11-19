package uibasics;

import model.Article;
import resourcemanager.ResourceManager;
import java.util.*;
import authoring.controller.AuthoringController;
import config.Config;
import front.commands.AbstractCommand;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class UIBasics{
  private Pane myPane;
  private List<Article> myBackArticles;
  private List<ImageView> myFrontArticles;
  private List<AbstractCommand> myCommands;
  private AuthoringController authoringController;
  private UIStackPane myStackPane;

  public UIBasics() {
    // load("commands"); temporarily off

    myPane = new Pane();
    // myPane.getChildren().add(new Rectangle(50, 50, 50, 50));
    myBackArticles = new ArrayList<Article>();
    myFrontArticles = new ArrayList<ImageView>();
    authoringController = new AuthoringController();
    //myStackPane.addPane(myPane);
    //Authoring();


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

  @SuppressWarnings("unchecked")
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
  }

  public AuthoringController getAuthoringController() {
    return authoringController;
  }

  public void setAuthoringController(AuthoringController authoringController) {
    this.authoringController = authoringController;
  }
}
