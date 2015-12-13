package menu;

import java.util.ResourceBundle;

public class ArticleMenuItem extends ImageMenuItem {

	public ArticleMenuItem(ResourceBundle resource, MenuController menuController) {
		super(resource, menuController, "NEWARTICLE");
	}

	@Override
	public ImageFolders imageFolder() {
		return ImageFolders.ARTICLE;
	}

}
