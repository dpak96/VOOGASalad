package menu;

import java.util.ResourceBundle;

public abstract class ImageMenuItem extends AbstractMenuItem {

	public ImageMenuItem(ResourceBundle resource, MenuController menuController, String imageType) {
		super(resource);
		this.setText(myResource.getString(imageType));
		this.setOnAction(e -> handle(menuController));
	}

	@Override
	public void handle(MenuController menuController) {
		menuController.addImage(imageFolder());

	}
	
	public abstract ImageFolders imageFolder();

}
