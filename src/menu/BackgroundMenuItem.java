package menu;

import java.util.ResourceBundle;

public class BackgroundMenuItem extends AbstractMenuItem {

	public BackgroundMenuItem(ResourceBundle resource, MenuController menuController) {
		super(resource);
		this.setText(myResource.getString("NEWBACKGROUND"));
//		this.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
		this.setOnAction(e -> handle(menuController));
	}

	@Override
	public void handle(MenuController menuController) {
		menuController.addImage("backgrounds");
	}
	
}
