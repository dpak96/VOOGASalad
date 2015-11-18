//This entire file is a part of my masterpiece
//Alex Rice
package menu;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ResourceBundle;

import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class SaveMenuItem extends AbstractMenuItem {

	public SaveMenuItem(ResourceBundle resource, MenuController menuController) {
		super(resource);
		this.setText(myResource.getString("SAVE"));
		this.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
		this.handle(menuController);

	}

	@Override
	public void handle(MenuController menuController) {
		this.setOnAction(e -> menuController.trySave(myFileChooser,myResource.getString("SAVE")));
	}
}
