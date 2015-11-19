package authoring.ui.editingmenus;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


public class MenuBuilder {

    public void makeLabel(GridPane gridPane,  int colIndex,int rowIndex, String labelName){
        Label newLabel=new Label(labelName);
        gridPane.add(newLabel, colIndex, rowIndex);
    }
}
