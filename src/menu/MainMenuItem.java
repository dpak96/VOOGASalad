package menu;

import java.util.ResourceBundle;

import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import startscreen.StartScreenController;

public class MainMenuItem extends AbstractMenuItem {
	
	
	public MainMenuItem(ResourceBundle resource, MenuController menuController){
		super(resource);
		this.setText(myResource.getString("MAINMENU"));
//		this.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
		handle(menuController);
	}


	@Override
	public void handle(MenuController menuController) {
		this.setOnAction(e ->menuController.newStart());
	}



}
