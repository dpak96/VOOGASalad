package uibasics;

import java.util.ResourceBundle;

import action.controller.ActionController;
import javafx.scene.Group;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import main.GraphicHandler;
import menu.MenuController;
import properties.VoogaProperties;

public class UICore {
	
	private BorderPane myRoot;
	private UIStackPane uiStackPane;
	private MenuController menuController;
	private Scene myScene;
	
	public UICore (GraphicHandler graphicHandler, ResourceBundle resources, ActionController actionController){
		VoogaProperties props = new VoogaProperties();
		myRoot = new BorderPane();
		menuController = new MenuController(graphicHandler, resources);
		uiStackPane = new UIStackPane();
		myScene = new Scene(myRoot, props.getSceneWidth(), props.getSceneHeight());
		borderInit(props);
		myScene.setOnKeyPressed(e -> actionController.update(e.getCode().toString()));
		myScene.setOnMouseClicked(e -> actionController.update(e.toString()));
	}
	
	public void borderInit(VoogaProperties props) {
		myRoot.setCenter(uiStackPane.getStack());
		myRoot.setTop(menuController.getMenu());
		myRoot.setPrefWidth(props.getSceneWidth());
		myRoot.setPrefHeight(props.getSceneHeight());
	}
	
	public Scene getScene(){
		myScene.getStylesheets().addAll("authoring/Overlay.css");
		return myScene;
	}
	
	public Pane getStack() {
		return uiStackPane.getStack();
	}
	
	public UIBasics getUIBasics() {
		return uiStackPane.getUIBasics();
	}
	
	public MenuController getMenu() {
		return menuController;
	}
	
//	private void handleKeyInput(KeyCode key){
////		(key.toString());
//	}
//	
//	private void handleClick(){
////		notifyObservers("click");
//	}
}

