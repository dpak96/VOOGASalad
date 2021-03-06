package authoring.ui.editingmenus;

import authoring.controller.AuthoringController;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CollisionMenu extends AuthoringMenu {

	private TextField myCollisionName = new TextField();

	public CollisionMenu(String title, AuthoringController controller) {
		super(title, controller);
		super.showMenu(300, 300);
	}

	@Override
	protected void populateMenu(GridPane menuPane) {
		menuPane.setHgap(10);
		super.componentAdder.makeLabel(menuPane, 1, 1, "Collision Name");
		menuPane.add(myCollisionName, 2, 1);
	}

	@Override
	public void executeYourMenuFunction() {
	    try{
	    super.myController.callEvent("OtherController","addCollisionType",myCollisionName.getText())
	}
	    catch(IllegalArgumentException e){
	        super.displayErrorMessage();
	    }
	}

}
