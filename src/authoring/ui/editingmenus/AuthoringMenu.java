package authoring.ui.editingmenus;

import javafx.animation.ScaleTransition;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Alert.AlertType;
import java.util.ResourceBundle;
import authoring.controller.AuthoringController;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.util.Duration;
import model.article.Article;
import resourcemanager.ResourceManager;


public abstract class AuthoringMenu implements IMenuAction {
    protected MenuBuilder componentAdder = new MenuBuilder();
    protected AuthoringController myController;
    protected ComboBoxImageRendering renderer=new ComboBoxImageRendering();
    private String myTitle;

    public AuthoringMenu (String title, AuthoringController controller) {
        myController = controller;
        myTitle = title;
    }

    public void showMenu (int menuWidth, int menuHeight) {

        Dialog propertyMenu = new Dialog();

        propertyMenu.setTitle(myTitle);

        GridPane menuGrid = new GridPane();
        menuGrid.setPrefSize(menuWidth, menuHeight);
        populateMenu(menuGrid);
        configureDialog(propertyMenu, menuGrid);
    }

    private void configureDialog (Dialog propertyMenu, GridPane menuGrid) {
        propertyMenu.getDialogPane().setContent(menuGrid);
        propertyMenu.getDialogPane().getButtonTypes().add(ButtonType.OK);
        propertyMenu.showAndWait().filter(selection -> selection == ButtonType.OK)
                .ifPresent(action -> this.executeYourMenuFunction());
    }

    protected void displayErrorMessage () {

        Alert invalidInput = new Alert(AlertType.INFORMATION);
        invalidInput.setTitle("Invalid input");
        ResourceBundle bundle =
                (ResourceBundle) ResourceManager.getResourceManager()
                        .getResource("PropertiesManager", "error");
        
        invalidInput.setContentText(bundle.getString("numberInput"));
        invalidInput.show();
    }
    
    protected abstract void populateMenu (GridPane menuPane);
}
