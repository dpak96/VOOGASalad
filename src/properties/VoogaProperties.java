package properties;

import java.util.ResourceBundle;

import javafx.stage.Screen;

public class VoogaProperties {
	private ResourceBundle myConfigRes;
	private double multiplier;
	
	public VoogaProperties(){
		myConfigRes = ResourceBundle.getBundle("properties/config");
		multiplier = Double.parseDouble(myConfigRes.getString("MULTIPLIER"));
	}

	public double getSceneWidth() {
		return Screen.getPrimary().getVisualBounds().getWidth() * multiplier;
	}

	public double getSceneHeight(){
		return Screen.getPrimary().getVisualBounds().getHeight() * multiplier;
	}
	
}