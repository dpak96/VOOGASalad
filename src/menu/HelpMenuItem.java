package menu;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;


public class HelpMenuItem extends AbstractMenuItem {
	
	public HelpMenuItem(ResourceBundle resource, MenuController menuController){
		super(resource);
		this.setText(myResource.getString("HELP"));
	    this.setAccelerator(KeyCombination.keyCombination("Ctrl+H"));

	}
	@Override
	public void handle(MenuController menuController) {
    }


}
