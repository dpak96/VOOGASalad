package uibasics;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import properties.VoogaProperties;

public class Setup{
	private Group myRoot;
	private Scene myScene;
	
	public Setup(){
		VoogaProperties penisAss = new VoogaProperties();
		this.myRoot = new Group();
		this.myScene = new Scene(myRoot, penisAss.getSceneHeight(), penisAss.getSceneWidth());
		myRoot.getChildren().add(new Layout());
	}

}
