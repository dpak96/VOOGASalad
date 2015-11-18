//This entire file is a part of my masterpiece
//Alex Rice
package menu;

import java.util.ResourceBundle;

import javafx.scene.control.MenuItem;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public abstract class AbstractMenuItem extends MenuItem {

	protected FileChooser myFileChooser;
	protected ResourceBundle myResource;
	
	public AbstractMenuItem(ResourceBundle resource){
		super();
		myResource = resource;
		myFileChooser = new FileChooser();
		FileChooser.ExtensionFilter extensionFilter =
		        new FileChooser.ExtensionFilter("Java files (*.ser)", "*.ser");
		myFileChooser.getExtensionFilters().add(extensionFilter);

	}
	public abstract void handle(MenuController menuController);
}
