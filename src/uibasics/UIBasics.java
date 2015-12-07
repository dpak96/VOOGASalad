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


public class UIBasics {
  private Pane myPane;
  private List<Article> myBackArticles;
  private List<ImageView> myFrontArticles;
  private List<AbstractCommand> myCommands;
  private ModelController myModelController;
//  private ImageView chara;

  public UIBasics(ModelController modelController) {
    load("commands");
    myPane = new Pane();
    myModelController = modelController;
    myBackArticles = new ArrayList<Article>();
    myFrontArticles = new ArrayList<ImageView>();
//    chara = new ImageView();
  }

  private void load(String identifier) {
    myCommands = new ArrayList<AbstractCommand>();
    String[] myVals =
        Config.getStringArray(String.format("%s.%s", this.getClass().getName(), identifier));
    for (String s : myVals) {
      myCommands.add(Config.getObject(s));
    }
    for (AbstractCommand c : myCommands) {
      System.out.println(c);
    }
  }

  public Pane getPane() {
    return myPane;
  }

  public void update(List<Article> list, Article character, String backImage) {
    clearAll();
    myBackArticles = list;
    for (Article value : myBackArticles) {
    	//For the Authoring Environment Offset
		Image img = (Image) ResourceManager.getResourceManager().getResource("ImageManager", value.getImageFile());
		double width = img.getWidth();
		int iSizeX = (int) (value.getWidth()/width);
		for (int i = 0; i < iSizeX; i++) {
			articleUpdate(value, i, width);
		}
    }
    articleUpdate(character, 0, 0);
    myPane.getChildren().addAll(myFrontArticles);
    setBackImage(backImage);
  }

  public void articleUpdate(Article article, int offset, double width) {
    ImageView img = new ImageView();
    commands(article, img);
    //For the Authoring Environment Offset
    img.setX(img.getX()+(offset*width));
    myFrontArticles.add(img);
  }
  
//  public void articleUpdateCharacter(Article article) {
//	    chara = new ImageView();
//	    commands(article, chara);
//	    myFrontArticles.add(chara);
//	  }

  private void commands(Article article, ImageView img) {
    for (AbstractCommand c : myCommands)
      c.update(article, myModelController, img);
  }

  private void clearAll() {
    myPane.getChildren().removeAll(myFrontArticles);
    myFrontArticles.clear();
  }

  public void setBackImage(String img) {
	try {
	    BackgroundSize size = new BackgroundSize(100, 100, true, true, true, false);
	    BackgroundPosition pos = new BackgroundPosition(null, -myModelController.getViewpoint().getX(), 
	    		false, null, myModelController.getViewpoint().getY(), false);
	    BackgroundImage back =
	        new BackgroundImage((Image) resourcemanager.ResourceManager.getResourceManager()
	            .getResource("ImageManager", img),
	                            BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, pos, size);

	    myPane.setBackground(new Background(back));
	} catch (NullPointerException e) {
	    myPane.setBackground(null);
	}

  }

}
