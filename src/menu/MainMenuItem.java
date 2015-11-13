package menu;

import java.util.ResourceBundle;

import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class MainMenuItem extends AbstractMenuItem {
	
	
	public MainMenuItem(ResourceBundle resource, Stage stage){
		super(resource, stage);
		this.setText(myResource.getString("MAINMENU"));
//		this.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
	}

	@Override
	public void handle() {
		// TODO : wangs	
	}
}
