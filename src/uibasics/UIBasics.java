package uibasics;

import model.Article;
import state.turtle.TurtleState;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

public class UIBasics implements Observer {
	private Pane myPane;
	private HashMap<String, Article> myBackArticles;
	private List<ImageView> myFrontArticles;
	
	public UIBasics(){
		myPane = new Pane();
		myPane.getChildren().add(new Rectangle(50, 50, 50, 50));
		myBackArticles = new HashMap<String, Article>();
		myFrontArticles = new ArrayList<ImageView>();
	}
	
	public Pane getPane(){
		return myPane;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void update(Observable o, Object arg) {
		myBackArticles = ((HashMap<String, Article>) arg);
		myBackArticles.
	}	
	
	
}
