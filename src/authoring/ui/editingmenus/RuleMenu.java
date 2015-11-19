package authoring.ui.editingmenus;

import java.util.ArrayList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Article;

public class RuleMenu extends AuthoringMenu{

    public RuleMenu (String title) {
        super(title);

    }

    ArrayList<String> ruleParameters=new ArrayList<String>();
    
    @Override
    public void executeYourMenuFunction () {
        // TODO Auto-generated method stub
        
    }

    @Override
    protected void populateMenu (GridPane menuPane) {
        menuPane.setPrefWidth(300);
        menuPane.setPrefHeight(300);
        super.componentAdder.makeLabel(menuPane, 1, 1, "Rule Type: ");
        ComboBox ruleTypeBox=new ComboBox();
        menuPane.add(ruleTypeBox, 2, 1);
        ruleTypeBox.getItems().add("Gravity");
        ruleTypeBox.setOnAction(e -> addParameterFields(menuPane));
        
    }
    
    public void addParameterFields(GridPane menuPane){
        menuPane.add(new Label("Gravity Value"), 1, 2);
        menuPane.add(new TextField(), 2, 2);
        
    }
   
}
