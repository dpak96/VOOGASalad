package uibasics;

import java.util.ResourceBundle;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import menu.MenuPanel;

public class Layout extends BorderPane{
	
	public Layout(Stage stage, ResourceBundle resources){
		this.setCenter(new UIBasics());
		this.setTop(new MenuPanel(stage, resources));
	}
}

