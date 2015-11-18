package uibasics;

import java.util.Observable;
import java.util.ResourceBundle;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import main.GraphicHandler;
import properties.VoogaProperties;

public class Setup extends Observable{
	private Group myRoot;
	private Scene myScene;
	
	public Setup(GraphicHandler graphicHandler, ResourceBundle resource){
		VoogaProperties properties = new VoogaProperties();
		this.myRoot = new Group();
		this.myScene = new Scene(myRoot, properties.getSceneWidth(), properties.getSceneHeight());
		myRoot.getChildren().add(new Layout(graphicHandler, resource));
		
	}
	
	public Scene getScene(){
		return myScene;
	}
	
	private void handleClickInput(){
		
	}
}

