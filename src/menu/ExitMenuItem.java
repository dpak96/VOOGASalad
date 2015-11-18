//This entire file is a part of my masterpiece
//Alex Rice
package menu;

import java.util.ResourceBundle;

import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class ExitMenuItem extends AbstractMenuItem {
	
	public ExitMenuItem(ResourceBundle resource, MenuController menuController) {
		super(resource);
		this.setText(myResource.getString("EXIT"));
		this.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));

	}
	
	@Override
	public void handle(MenuController menuController){
		System.exit(0);
	}
}
