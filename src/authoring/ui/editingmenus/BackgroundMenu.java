package authoring.ui.editingmenus;

import authoring.controller.AuthoringController;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

public class BackgroundMenu extends AuthoringMenu {

    ComboBox imageBox=new ComboBox();
    
    public BackgroundMenu (String title, AuthoringController controller) {
        super(title, controller);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void executeYourMenuFunction () {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void populateMenu (GridPane menuPane) {
        
        int rowIndex=1;
        imageBox=super.componentAdder.makeLabelAndBox(menuPane, 1, rowIndex, "Background Image: ");
        
    }

}
