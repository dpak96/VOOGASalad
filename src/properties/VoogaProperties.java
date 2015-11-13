package properties;

import javafx.stage.Screen;

public class VoogaProperties {

	public double getSceneWidth() {
		return Screen.getPrimary().getVisualBounds().getWidth();
	}

	public double getSceneHeight(){
		return Screen.getPrimary().getVisualBounds().getHeight();
	}
  
}