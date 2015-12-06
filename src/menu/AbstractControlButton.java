package menu;

import java.util.Map;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import resourcemanager.ResourceManager;

public abstract class AbstractControlButton extends Button {
	
	protected Map<String, Object> myImages = ResourceManager.getResourceManager().getResourceMap("ImageManager");
	protected ResourceBundle myStrings = (ResourceBundle) ResourceManager.getResourceManager().getResource("PropertiesManager", "english");
	
	public AbstractControlButton(){
		super();
	}
	
	public abstract void resize(MenuPanel menuPanel);
}
