// This entire file is part of my masterpiece.
// MATTHEW BATTLES
package menu;

import java.util.ResourceBundle;

public class BackgroundMenuItem extends ImageMenuItem {

	public BackgroundMenuItem(ResourceBundle resource, MenuController menuController) {
		super(resource, menuController, "NEWBACKGROUND");
	}

	@Override
	public ImageFolders imageFolder() {
		return ImageFolders.BACKGROUND;
	}
	
}
