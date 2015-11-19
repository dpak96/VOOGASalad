package authoring.ui.editingmenus;

import java.util.Map;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;


public class MenuBuilder {

    public void makeLabel(GridPane gridPane,  int colIndex,int rowIndex, String labelName){
        Label newLabel=new Label(labelName);
        gridPane.add(newLabel, colIndex, rowIndex);
    }
    
    public TextField makeField(GridPane gridPane, int colIndex,int rowIndex){
    TextField newField=new TextField();
    gridPane.add(newField, colIndex, rowIndex);
    return newField;
}

    
}