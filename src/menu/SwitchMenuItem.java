package menu;

import java.util.ResourceBundle;

import javafx.stage.Stage;

public class SwitchMenuItem extends AbstractMenuItem {

	public SwitchMenuItem(ResourceBundle resource, Stage stage) {
		super(resource, stage);
		this.setText(myResource.getString("SWITCH"));
//		this.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
	}

	@Override
	public void handle() {
		// TODO Auto-generated method stub
	}
}
