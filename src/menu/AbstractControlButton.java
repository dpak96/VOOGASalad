package menu;

import java.util.Map;
import java.util.ResourceBundle;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import resourcemanager.ResourceManager;

public abstract class AbstractControlButton extends Button {
	
	protected Map<String,Image> myImages = ResourceManager.getResourceManager().getIm().getImageMap();
	protected ResourceBundle myStrings = ResourceManager.getResourceManager().getPm().getResourceMap().get("english");
	
	public AbstractControlButton(){
		super();
	}
	
	public abstract void resize(MenuPanel menuPanel);
}
