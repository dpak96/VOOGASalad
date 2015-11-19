package uibasics;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import authoring.controller.AuthoringController;
import game.player.GamePlayerOverlay;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import model.Article;

public class UIStackPane implements Observer {
	private StackPane myStackPane;
	private UIBasics myUIBasics;
	private AuthoringController authoringController;
	private GamePlayerOverlay myGamePlayer;
	private Pane myActive;
	
	public UIStackPane() {
		myStackPane = new StackPane();
		initializePanes();
	}
	
	public void initializePanes() {
		myUIBasics = new UIBasics();
		authoringController = new AuthoringController();
		myGamePlayer = new GamePlayerOverlay();
//		if (edit) //currently inactive
			myActive = authoringController.getUi().tester();
//		else
//			myActive = gamePlayerController.getPane();
		myStackPane.getChildren().add(myUIBasics.getPane());
		myStackPane.getChildren().add(myActive);
	}
	
	public void toggle() {
//		if (edit) 
//			myActive = gamePlayerController.getPane();
//		else
//			myActive = authoringController.getUi().tester();
	}
	
	 public AuthoringController getAuthoringController() {
		 return authoringController;
	 }

	 public void setAuthoringController(AuthoringController authoringController) {
		 this.authoringController = authoringController;
	 }
	
	public StackPane getStack(){
		return myStackPane;
	}
	
	public UIBasics getUIBasics(){
		return myUIBasics;
	}

	@Override
	public void update(Observable o, Object arg) {
		@SuppressWarnings("unchecked")
		ArrayList<Article> articles = (ArrayList<Article>) arg;
		myUIBasics.update(articles);
		myGamePlayer.update(articles);
	}
	


}
