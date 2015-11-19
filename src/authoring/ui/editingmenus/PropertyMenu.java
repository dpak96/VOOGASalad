package authoring.ui.editingmenus;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import model.Article;


public abstract class PropertyMenu implements IMenuAction {
    protected Object objectToEdit;
    protected MenuBuilder componentAdder=new MenuBuilder();
    
    public void showMenu (String title) {

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
