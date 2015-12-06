package authoring.ui.editingmenus;

import authoring.controller.AuthoringController;
import javafx.scene.layout.GridPane;

public class AddEventMenu  extends AuthoringMenu {

    public AddEventMenu (String title, AuthoringController controller) {
        super(title, controller);

    }

    @Override
    public void executeYourMenuFunction () {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void populateMenu (GridPane menuPane) {

        super.componentAdder.makeLabel(menuPane, 1, 1, "Name :");
        super.componentAdder.makeField(menuPane, 2, 1);
    }

}
