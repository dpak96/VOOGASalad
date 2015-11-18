package uibasics;

import java.util.ResourceBundle;

import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.GraphicHandler;
import menu.MenuController;
import menu.MenuPanel;
import properties.VoogaProperties;

public class Layout extends BorderPane{
	
	public Layout(GraphicHandler graphicHandler, ResourceBundle resources){
		VoogaProperties props = new VoogaProperties();
		this.setCenter(new UIStackPane().getStack());
		this.setTop(new MenuController(graphicHandler, resources).getMenu());
		this.setPrefWidth(props.getSceneWidth());
		this.setPrefHeight(props.getSceneHeight());
	}
}

