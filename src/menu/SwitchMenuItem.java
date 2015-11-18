package menu;

import java.util.ResourceBundle;

import javafx.stage.Stage;

public class SwitchMenuItem extends AbstractMenuItem {

	public SwitchMenuItem(ResourceBundle resource, MenuController menuController) {
		super(resource);
		this.setText(myResource.getString("SWITCH"));
		handle(menuController);
//		this.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
	}

	@Override
	public void handle(MenuController menuController) {
		// TODO Auto-generated method stub
	}
}
