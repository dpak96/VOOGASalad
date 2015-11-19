package uibasics;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import authoring.controller.AuthoringController;
import game.player.GamePlayerOverlay;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import model.Article;
import model.Model;
import model.controller.ModelController;

public class UIStackPane extends StackPane implements Observer {
	private UIBasics myUIBasics;
	private AuthoringController myAuthoringController;
	private GamePlayerOverlay myGamePlayer;
	private boolean edit;
	private Pane myAuthoringControllerPane;
	
	public UIStackPane(ModelController modelController) {

		myAuthoringController = new AuthoringController(modelController);
		initializePanes();
	}

	public void initializePanes() {
		edit = true;
		myUIBasics = new UIBasics();
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
		Model model = (Model) o;
		myUIBasics.update(model.getArticles());
		myGamePlayer.update(model.getArticles(), model.getCharacter());
	}

}
