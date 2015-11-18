package uibasics;

import java.util.Observable;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class UIStackPane extends Observable {
	private StackPane myStackPane;
	
	public UIStackPane() {
		myStackPane = new StackPane();
		myStackPane.setOnKeyPressed(e -> handleKeyInput(e.getCode()));
		myStackPane.setOnMouseClicked(e -> handleClick());
	}
	
	public StackPane getStack(){
		return myStackPane;
	}
	
	public void addPane(Pane pane) {
		myStackPane.getChildren().add(pane);
	}
	
	public void removePane() {
		myStackPane.getChildren().remove(myStackPane.getChildren().size()-1);
	}
	
	private void handleKeyInput(KeyCode key){
		notifyObservers(key.toString());
	}
	
	private void handleClick(){
		notifyObservers("click");
	}

}
