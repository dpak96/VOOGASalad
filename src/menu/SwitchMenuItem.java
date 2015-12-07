package menu;

import java.util.ResourceBundle;

import javafx.stage.Stage;
import startscreen.GameCreation;

public class SwitchMenuItem extends AbstractMenuItem {
	private boolean edit;

	public SwitchMenuItem(ResourceBundle resource, MenuController menuController) {
		super(resource);
		this.setText(myResource.getString("SWITCH"));
		handle(menuController);
//		this.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
	}

	@Override
	public void handle(MenuController menuController) {
		this.setOnAction(e -> menuController.switchOverlay());
	}
}
