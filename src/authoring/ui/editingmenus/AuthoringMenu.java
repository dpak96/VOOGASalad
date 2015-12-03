package authoring.ui.editingmenus;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import authoring.controller.AuthoringController;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import model.Article;


public abstract class AuthoringMenu implements IMenuAction {
    protected MenuBuilder componentAdder = new MenuBuilder();
    protected AuthoringController myController;
    public AuthoringMenu (String title, AuthoringController controller) {
        myController=controller;
        showMenu(title);
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

    protected abstract void populateMenu (GridPane menuPane);
}
