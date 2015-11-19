package authoring.ui.editingmenus;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import model.Article;


public abstract class AuthoringMenu implements IMenuAction {
    protected MenuBuilder componentAdder = new MenuBuilder();

    public AuthoringMenu (String title) {
        showMenu(title);
    }

    public void showMenu (String title) {

        Dialog propertyMenu = new Dialog();
        propertyMenu.setTitle("Enemy Property Editor");

        GridPane menuGrid = new GridPane();
        menuGrid.setPrefSize(300, 300);
        populateMenu(menuGrid);
        propertyMenu.getDialogPane().setContent(menuGrid);

        propertyMenu.getDialogPane().getButtonTypes().add(ButtonType.OK);

        propertyMenu.showAndWait().filter(selection -> selection == ButtonType.OK)
                .ifPresent(action -> this.executeYourMenuFunction());
        ;
    }

    protected abstract void populateMenu (GridPane menuPane);
}
