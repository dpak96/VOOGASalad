package menu;

import java.util.ResourceBundle;

import javafx.stage.Stage;

public class ControlMenuItem extends AbstractMenuItem {

	public ControlMenuItem(ResourceBundle resource, Stage stage) {
		super(resource, stage);
		this.setText(myResource.getString("CONTROLS"));
//		this.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
		// TODO Auto-generated constructor stub
	}

	@Override
	public void handle() {
		// TODO Auto-generated method stub

	}

}
