package authoring.ui.editingmenus;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Alert.AlertType;
import authoring.controller.AuthoringController;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import model.Article;
import resourcemanager.ResourceManager;


public abstract class AuthoringMenu implements IMenuAction {
    protected MenuBuilder componentAdder = new MenuBuilder();
    protected AuthoringController myController;

    public AuthoringMenu (String title, AuthoringController controller) {
        myController = controller;
    }

    public void showMenu (String title) {

        Dialog propertyMenu = new Dialog();

        propertyMenu.setTitle(title);

        GridPane menuGrid = new GridPane();
        menuGrid.setPrefSize(300, 300);
        populateMenu(menuGrid);
        propertyMenu.getDialogPane().setContent(menuGrid);
        propertyMenu.getDialogPane().getButtonTypes().add(ButtonType.OK);

        propertyMenu.showAndWait().filter(selection -> selection == ButtonType.OK)
                .ifPresent(action -> this.executeYourMenuFunction());

    }

    protected Double parseDouble (String input) {
        try {

            Double parsedNum = Double.parseDouble(input);
            return parsedNum;
        }
        catch (Exception e) {
            Alert invalidInput = new Alert(AlertType.INFORMATION);
            invalidInput.setTitle("Invalid input");
            invalidInput.setContentText(ResourceManager.getResourceManager().getPm()
                    .getResourceMap().get("error").getString("numberInput"));
            invalidInput.show();
        }
        return 0.0;
    }

    protected abstract void populateMenu (GridPane menuPane);
}
