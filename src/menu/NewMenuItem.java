//This entire file is a part of my masterpiece
//Alex Rice
package menu;

import java.util.ResourceBundle;

import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class NewMenuItem extends AbstractMenuItem {
	
	public NewMenuItem(ResourceBundle resource, Stage stage){
		super(resource, stage);
		this.setText(myResource.getString("NEW"));
	    this.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));

	}
	@Override
	public void handle() {
//		SlogoScene currScene = myController.getMyScene();
//	    GUIManager currGuiManager = myController.getGuiManager();
//	    new ModelController(myStage, currGuiManager, currScene);
	}

}
