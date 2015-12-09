package menu;

import java.util.ResourceBundle;

public class PlatformMenuItem extends AbstractMenuItem {

	public PlatformMenuItem(ResourceBundle resource, MenuController menuController) {
		super(resource);
		this.setText(myResource.getString("NEWPLATFORM"));
//		this.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
		this.setOnAction(e -> handle(menuController));
	}

	@Override
	public void handle(MenuController menuController) {
		menuController.addImage("platforms");
	}

}
