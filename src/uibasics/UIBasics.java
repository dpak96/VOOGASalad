package uibasics;

import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;

public class UIBasics extends StackPane {
	
	public UIBasics(){
		this.getChildren().add(new Rectangle(50, 50, 50, 50));
	}


}
