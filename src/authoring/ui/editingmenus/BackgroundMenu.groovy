//This entire file is part of my masterpiece
//Jasper Hancock

package authoring.ui.editingmenus;

import authoring.controller.AuthoringController;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;

public class BackgroundMenu extends AuthoringMenu {

    private ComboBox<String> imageBox=new ComboBox<String>();
    private ComboBoxImageRendering imageHandler=new ComboBoxImageRendering();
    private static final int MENU_WIDTH=300;
    private static final int MENU_HEIGHT=300;
    
    public BackgroundMenu (String title, AuthoringController controller) {
        super(title, controller,MENU_WIDTH,MENU_HEIGHT);
    }

    @Override
    public void executeYourMenuFunction () {

            super.myController.getEditor().getSubEditor("LevelEditor").setBackgroundImage(imageBox.getValue());
    }

    public void populateMenu (GridPane menuPane) {
        
        int rowIndex=1;
        imageBox=super.componentAdder.makeLabelAndBox(menuPane, 1, rowIndex, "Background Image: ");
        imageBox.getItems().add(" ");
        imageHandler.addBackgroundImages(imageBox);
        
       
    }
    
}
