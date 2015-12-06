package authoring.ui.editingmenus;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import authoring.controller.AuthoringController;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import resourcemanager.ResourceManager;

public class EventParameters {
    private AuthoringController myController;
    public EventParameters(AuthoringController controller){
        myController=controller;
    }

    private MenuBuilder componentAdder=new MenuBuilder();

    public Map<String,Control> populateCollisionEventParameters(GridPane paramGrid){
        Map<String,Control> fieldMap=new HashMap<String,Control>();
        componentAdder.makeLabel(paramGrid, 1, 1, "Direction");
        ComboBox directionBox=componentAdder.makeComboBox(paramGrid, 2, 1);
        directionBox.getItems().addAll(Arrays.asList("Left","Right","Top","Bottom"));
       /* ResourceBundle directions=(ResourceBundle) ResourceManager.getResourceManager().getResource("PropertiesManager", "collisionDirections");
        Enumeration bundleKeys=directions.getKeys();
        while(bundleKeys.hasMoreElements()){
            String direction=(String) bundleKeys.nextElement();
            directionBox.getItems().add(direction);
        }*/
        fieldMap.put("direction", directionBox);
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
    
    public Map<String,Control> populateButtonEventParameters(GridPane paramGrid){
        Map<String,Control> fieldMap=new HashMap<String,Control>();
        componentAdder.makeLabel(paramGrid, 1, 1, "Key Press");
        fieldMap.put("button", componentAdder.makeField(paramGrid, 2, 1));
        return fieldMap;
        
    }
}
