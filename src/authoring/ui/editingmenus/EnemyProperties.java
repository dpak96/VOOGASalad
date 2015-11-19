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
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Popup;
import model.Article;


public class EnemyProperties extends ArticleEditorMenu {
    private HashMap<String, TextField> textFieldPropertyMap;
    private HashMap<String,ComboBox> comboBoxPropertyMap;

    public EnemyProperties (String title,Article enemy) {
        super(title,enemy);
    }
    
    protected void populateMenu (GridPane menuGrid) {
        textFieldPropertyMap=new HashMap<String,TextField>();
        comboBoxPropertyMap=new HashMap<String,ComboBox>();
        int rowIndex = 1;       
        
        super.componentAdder.makeLabel(menuGrid, 1, rowIndex, "Name: ");
        textFieldPropertyMap.put("NAME",(super.componentAdder.makeField(menuGrid, 2, rowIndex++)));
      

        super.componentAdder.makeLabel(menuGrid, 1, rowIndex, "Velocity: ");
        textFieldPropertyMap.put("VELOCITY",(super.componentAdder.makeField(menuGrid, 2, rowIndex++)));
        

        super.componentAdder.makeLabel(menuGrid, 1, rowIndex, "Image: ");
        comboBoxPropertyMap.put("IMAGE", super.componentAdder.makeComboBox(menuGrid, 2, rowIndex++));

        super.componentAdder.makeLabel(menuGrid, 1, rowIndex, "Action on Collision: ");
        comboBoxPropertyMap.put("COLLISION", super.componentAdder.makeComboBox(menuGrid, 2, rowIndex++));

        super.componentAdder.makeLabel(menuGrid, 1, rowIndex, "Save as default?: ");
        CheckBox defaultSave = new CheckBox();
        menuGrid.add(defaultSave, 2, rowIndex++);
        
      

    }

    public void addImages(ComboBox imageBox){
       // imageBox.getItems().add()
    }
    @Override
    public void executeYourMenuFunction () {
      //  objectToEdit.setImageFile(comboBoxPropertyMap.get("IMAGE").getp);
        // Pass on the edits to the thing being edited
    }

}
