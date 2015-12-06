package authoring.ui.editingmenus;

import java.util.HashMap;
import java.util.Map;
import authoring.controller.AuthoringController;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CollisionEventParameters {
    private AuthoringController myController;
    public CollisionEventParameters(AuthoringController controller){
        myController=controller;
    }

    private MenuBuilder componentAdder=new MenuBuilder();
    public Map<String,Control> populateCollisionEventParameters(GridPane paramGrid){
        Map<String,Control> fieldMap=new HashMap<String,Control>();
        componentAdder.makeLabel(paramGrid, 1, 1, "Direction");
        fieldMap.put("direction", componentAdder.makeField(paramGrid, 2, 1));
        componentAdder.makeLabel(paramGrid, 1, 2, "Collision Type One");
        ComboBox firstCollisionTypeBox=componentAdder.makeComboBox(paramGrid, 2, 2);
        firstCollisionTypeBox.getItems().addAll(myController.getCollisionTypes());
        fieldMap.put("nameOne",firstCollisionTypeBox);
        componentAdder.makeLabel(paramGrid, 1, 3, "Collision Type Two");
        ComboBox secondCollisionTypeBox=componentAdder.makeComboBox(paramGrid, 2, 3);
        secondCollisionTypeBox.getItems().addAll(myController.getCollisionTypes());
        fieldMap.put("nameTwo",secondCollisionTypeBox);
        
        
        return fieldMap;
        
        
        
        
        
    }
}
