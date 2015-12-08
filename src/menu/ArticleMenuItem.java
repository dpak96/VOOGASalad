package menu;

import java.util.ResourceBundle;

import javafx.scene.input.KeyCombination;

public class ArticleMenuItem extends AbstractMenuItem {

	public ArticleMenuItem(ResourceBundle resource, MenuController menuController) {
		super(resource);
		this.setText(myResource.getString("NEWARTICLE"));
//		this.setAccelerator(KeyCombination.keyCombination("Ctrl+A"));
		this.setOnAction(e -> handle(menuController));
	}

	@Override
	public void handle(MenuController menuController) {
		menuController.addImage("articles");
	}

}
