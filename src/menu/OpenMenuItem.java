//This entire file is a part of my masterpiece
//Alex Rice
package menu;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ResourceBundle;

import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import main.GraphicHandler;

public class OpenMenuItem extends AbstractMenuItem {

	public OpenMenuItem(ResourceBundle resource,MenuController menuController) {
		super(resource);
		this.setText(myResource.getString("OPEN"));
		this.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
		handle(menuController);
	}

	@Override
	public void handle(MenuController menuController) {
		this.setOnAction(e-> menuController.something(myResource,myFileChooser));
	}
}
