package authoring.ui.editingmenus;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;


public abstract class PropertyMenu implements IMenuAction {

    public void showMenu (String title /* Article being acted on */) {

        Dialog propertyMenu = new Dialog();
        propertyMenu.setTitle("Enemy Property Editor");

        GridPane menuGrid = new GridPane();

        populateMenu(menuGrid);
        propertyMenu.getDialogPane().setContent(menuGrid);

        ButtonType buttonTypeOk = new ButtonType("Okay", ButtonData.OK_DONE);

        propertyMenu.getDialogPane().getButtonTypes().add(buttonTypeOk);

        propertyMenu.showAndWait().filter(selection -> selection == ButtonType.OK)
                .ifPresent(action -> this.executeYourMenuFunction() );;
    }

    protected abstract void populateMenu (GridPane menuPane);
}
