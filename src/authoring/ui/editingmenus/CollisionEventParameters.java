package authoring.ui.editingmenus;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class CollisionEventParameters {

    private MenuBuilder componentAdder=new MenuBuilder();
    public void populateCollisionEventParameters(GridPane paramGrid){
        componentAdder.makeLabel(paramGrid, 1, 1, "Direction");
        componentAdder.makeField(paramGrid, 2, 1);
        componentAdder.makeLabel(paramGrid, 1, 2, "Collision Type One");
        componentAdder.makeComboBox(paramGrid, 2, 2);
        componentAdder.makeLabel(paramGrid, 1, 3, "Collision Type Two");
        componentAdder.makeComboBox(paramGrid, 2, 3);
        
        
        
        
        
    }
}
