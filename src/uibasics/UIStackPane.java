package uibasics;

import java.util.Observable;

import authoring.controller.AuthoringController;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class UIStackPane extends Observable {
	private StackPane myStackPane;
	private UIBasics myUIBasics;
	private AuthoringController authoringController;
	private Pane myActive;
	
	public UIStackPane() {
		myStackPane = new StackPane();
		initializePanes();
		myStackPane.setOnKeyPressed(e -> handleKeyInput(e.getCode()));
		myStackPane.setOnMouseClicked(e -> handleClick());
	}
	
	public void initializePanes() {
		myUIBasics = new UIBasics();
		authoringController = new AuthoringController();
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
	
	private void handleKeyInput(KeyCode key){
		notifyObservers(key.toString());
	}
	
	private void handleClick(){
		notifyObservers("click");
	}

}
