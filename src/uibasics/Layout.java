package uibasics;

import java.util.ResourceBundle;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import menu.MenuPanel;
import properties.VoogaProperties;

public class Layout extends BorderPane{
	
	public Layout(Stage stage, ResourceBundle resources){
		VoogaProperties props = new VoogaProperties();
		this.setCenter(new UIStackPane());
		this.setTop(new MenuPanel(stage, resources));
		this.setPrefWidth(props.getSceneWidth());
		this.setPrefHeight(props.getSceneHeight());
	}
}

