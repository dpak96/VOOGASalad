package uibasics;

import java.util.ResourceBundle;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import properties.VoogaProperties;

public class Setup{
	private Group myRoot;
	private Scene myScene;
	
	public Setup(Stage stage, ResourceBundle resource){
		VoogaProperties penisAss = new VoogaProperties();
		this.myRoot = new Group();
		this.myScene = new Scene(myRoot, penisAss.getSceneHeight(), penisAss.getSceneWidth());
		myRoot.getChildren().add(new Layout(stage, resource));
	}
	
	public Scene getScene(){
		return myScene;
	}
}

