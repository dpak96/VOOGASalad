package uibasics;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class UIStackPane extends StackPane {
	
	public UIStackPane() {
		this.getChildren().add(new UIBasics().getPane());
	}
	
	public void addPane(Pane pane) {
		this.getChildren().add(pane);
	}
	
	public void removePane() {
		this.getChildren().remove(this.getChildren().size()-1);
	}

}
