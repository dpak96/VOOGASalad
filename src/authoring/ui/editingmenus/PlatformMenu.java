package authoring.ui.editingmenus;

import authoring.controller.AuthoringController;
import authoring.ui.draganddrop.DraggableElement;
import authoring.ui.toolbar.PlatformButton;
import authoring.ui.toolbar.ToolbarButton;
import javafx.scene.layout.GridPane;

public class PlatformMenu extends AuthoringMenu {

    public PlatformMenu (String title, AuthoringController controller) {
        super(title, controller);
        super.showMenu(300, 300);
    }

    @Override
    public void executeYourMenuFunction () {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void populateMenu (GridPane menuPane) {
        PlatformButton newPlatform=new PlatformButton(super.myController, "PLATFORM");
        menuPane.add(newPlatform, 1, 1);
        // TODO Auto-generated method stub
        
    }
    

}
