package main;

import java.util.ResourceBundle;

import javafx.stage.Screen;
import resourcemanager.ResourceManager;

public class VoogaProperties {
	private ResourceBundle myConfigRes;
	private double multiplier;
	
	public VoogaProperties(){
	  myConfigRes = (ResourceBundle) ResourceManager.getResourceManager().getResource("PropertiesManager", "config");
		multiplier = Double.parseDouble(myConfigRes.getString("MULTIPLIER"));
	}

	public double getSceneWidth() {
		return Screen.getPrimary().getVisualBounds().getWidth() * multiplier;
	}

	public double getSceneHeight(){
		return Screen.getPrimary().getVisualBounds().getHeight() * multiplier;
	}
	
}