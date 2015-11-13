package uibasics;

import java.util.Observable;

import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class UIBasics extends Observable{
	private StackPane myPane;
	public UIBasics(){
		myPane = new StackPane();
		myPane.getChildren().add(new Rectangle(50, 50, 50, 50));

	}
	
	public StackPane getPane(){
		return myPane;
	}
	

	
}
