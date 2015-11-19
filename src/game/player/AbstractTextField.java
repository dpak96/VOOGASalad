package game.player;

import java.util.ResourceBundle;

import javafx.scene.text.Text;
import resourcemanager.ResourceManager;

public abstract class AbstractTextField extends Text{
	private ResourceManager myResourceManager;
	private String mainText;
	
	public AbstractTextField(String text){
		mainText = myResourceManager.getPm().getResourceMap().get("english").getString(text);
		this.setText(mainText);
	}
	
	public void update(double newValue){
		this.setText(mainText + newValue);
	}
}
