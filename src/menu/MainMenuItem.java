package menu;

import java.util.ResourceBundle;

import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;
import startscreen.StartScreenController;

public class MainMenuItem extends AbstractMenuItem {
	
	
	public MainMenuItem(ResourceBundle resource, Stage stage){
		super(resource, stage);
		this.setText(myResource.getString("MAINMENU"));
//		this.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
	}

	@Override
	public void handle() {
		StartScreenController start = new StartScreenController();
		start.init(myStage);
		Scene mainMenu = new Scene(start.getStart(),400,400);
		mainMenu.getStylesheets().add("startscreen/StartScreen.css");
		myStage.setScene(mainMenu);
	}
}
