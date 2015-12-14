// This entire file is part of my masterpiece.
// MATTHEW BATTLES
package menu;

import java.util.ResourceBundle;

public class PlatformMenuItem extends ImageMenuItem {

	public PlatformMenuItem(ResourceBundle resource, MenuController menuController) {
		super(resource, menuController, "NEWPLATFORM");
	}

	@Override
	public ImageFolders imageFolder() {
		return ImageFolders.PLATFORM;
	}

}
