package authoring.ui.editingmenus;

import authoring.controller.AuthoringController;
import javafx.scene.layout.GridPane;
import javafx.stage.FileChooser;

public class UploadImageMenu extends AuthoringMenu{

	public UploadImageMenu(String title, AuthoringController controller) {
		super(title, controller, 300, 300);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void executeYourMenuFunction() {
	}

	@Override
	public void populateMenu(GridPane menuPane) {
		// TODO Auto-generated method stub
		FileChooser f = new FileChooser();
	}

}
