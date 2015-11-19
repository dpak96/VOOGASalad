package uibasics;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import authoring.controller.AuthoringController;
import game.player.GamePlayerOverlay;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import model.Article;

public class UIStackPane extends StackPane implements Observer {
	private UIBasics myUIBasics;
	private AuthoringController myAuthoringController;
	private GamePlayerOverlay myGamePlayer;
	private boolean edit;
	private Pane myAuthoringControllerPane;
	
	public UIStackPane() {
		initializePanes();
	}
	
	public void initializePanes() {
		edit = true;
		myUIBasics = new UIBasics();
		myAuthoringController = new AuthoringController();
		myGamePlayer = new GamePlayerOverlay();
		myAuthoringControllerPane = myAuthoringController.getUi().tester();
		this.getChildren().add(myUIBasics.getPane());
//		if (edit) //currently inactive
//			this.getChildren().add(myAuthoringControllerPane);
//		else
//			this.getChildren().add(myGamePlayer);
		this.getChildren().add(myAuthoringControllerPane);
	}
	
	public void toggle() {
		this.getChildren().remove(this.getChildren().size()-1);
		if (edit) {
			this.getChildren().add(myGamePlayer);
		} else {
			this.getChildren().add(myAuthoringControllerPane);
		}
		edit=!edit;
	}
	
	 public AuthoringController getAuthoringController() {
		 return myAuthoringController;
	 }

	 public void setAuthoringController(AuthoringController authoringController) {
		 this.myAuthoringController = authoringController;
	 }
	
	public StackPane getStack(){
		return this;
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
