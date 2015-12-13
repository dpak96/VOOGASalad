package authoring.ui.editingmenus;

import java.util.ResourceBundle;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import resourcemanager.ResourceManager;

public class ErrorPopup {
    public void displayErrorMessage () {

        Alert invalidInput = new Alert(AlertType.INFORMATION);
        invalidInput.setTitle("Invalid input");
        ResourceBundle bundle =
                (ResourceBundle) ResourceManager.getResourceManager()
                        .getResource("PropertiesManager", "error");
        
        invalidInput.setContentText(bundle.getString("numberInput"));
        invalidInput.show();
    }

}
