package authoring.ui.editingmenus;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CollisionEventParameters {

    private MenuBuilder componentAdder=new MenuBuilder();
    public Map<String,Control> populateCollisionEventParameters(GridPane paramGrid){
        Map<String,Control> fieldMap=new HashMap<String,Control>();
        componentAdder.makeLabel(paramGrid, 1, 1, "Direction");
        fieldMap.put("direction", componentAdder.makeField(paramGrid, 2, 1));
        componentAdder.makeLabel(paramGrid, 1, 2, "Collision Type One");
        fieldMap.put("nameOne",componentAdder.makeComboBox(paramGrid, 2, 2));
        componentAdder.makeLabel(paramGrid, 1, 3, "Collision Type Two");
        fieldMap.put("nameTwo",componentAdder.makeComboBox(paramGrid, 2, 3));
        
        return fieldMap;
        
        
        
        
        
    }
}
