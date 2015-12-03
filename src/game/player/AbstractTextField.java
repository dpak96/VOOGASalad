package game.player;

import java.util.ResourceBundle;

import javafx.scene.text.Text;
import resourcemanager.ResourceManager;

public abstract class AbstractTextField extends Text{
	private String mainText;
	
	public AbstractTextField(String text){
		ResourceBundle rb = (ResourceBundle) ResourceManager.getResourceManager().getResource("PropertiesManager", "english");
		mainText = rb.getString(text);
		this.setText(mainText);
	}
	
	public void update(double newValue){
		this.setText(mainText + newValue);
	}
}
