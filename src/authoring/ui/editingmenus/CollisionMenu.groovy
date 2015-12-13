//This entire file is part of my masterpiece
//Jasper Hancock
package authoring.ui.editingmenus;

import authoring.controller.AuthoringController;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CollisionMenu extends AuthoringMenu {

    private TextField myCollisionName = new TextField();
    private static final int MENU_WIDTH=300;
    private static final int MENU_HEIGHT=150;
    public CollisionMenu(String title, AuthoringController controller) {
        super(title, controller);
        super.showMenu(MENU_WIDTH, MENU_HEIGHT);
    }

    public void populateMenu(GridPane menuPane) {
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
            ErrorPopup popup=new ErrorPopup();
            popup.displayErrorMessage();
        }
    }

}
