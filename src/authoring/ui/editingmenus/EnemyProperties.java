package authoring.ui.editingmenus;

import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Popup;
import model.Article;


public class EnemyProperties extends ArticleEditorMenu {
    private HashMap<String, TextField> enemyPropertyMap;

    public EnemyProperties (String title,Article enemy) {
        super(title,enemy);
    }
    
    protected void populateMenu (GridPane menuGrid) {
        enemyPropertyMap=new HashMap<String,TextField>();
        int rowIndex = 1;       
        
        super.componentAdder.makeLabel(menuGrid, 1, rowIndex, "Name: ");
        enemyPropertyMap.put("NAME",(super.componentAdder.makeField(menuGrid, 2, rowIndex++)));
      

        super.componentAdder.makeLabel(menuGrid, 1, rowIndex, "Velocity: ");
        enemyPropertyMap.put("VELOCITY",(super.componentAdder.makeField(menuGrid, 2, rowIndex++)));


        Label imageLabel = new Label("Image: ");
        ComboBox imageBox = new ComboBox();

        menuGrid.add(imageLabel, 1, rowIndex);
        menuGrid.add(imageBox, 2, rowIndex++);

        Label collisionLabel = new Label("Action on Collision:  ");
        ComboBox collisionBox = new ComboBox();

        menuGrid.add(collisionLabel, 1, rowIndex);
        menuGrid.add(collisionBox, 2, rowIndex++);

        Label defaultOption = new Label("Save as default?");
        CheckBox defaultSave = new CheckBox();

        menuGrid.add(defaultOption, 1, rowIndex);
        menuGrid.add(defaultSave, 2, rowIndex++);

    }

    @Override
    public void executeYourMenuFunction () {
        // Pass on the edits to the thing being edited
    }

}
