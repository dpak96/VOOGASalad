package authoring.ui.editingmenus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.sun.naming.internal.ResourceManager;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Article;
import model.controller.ModelController;

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
        ruleTypeBox.setOnAction(e -> addParameterFields(ruleTypeBox,menuPane));
        
    }
    
    public void addParameterFields(ComboBox ruleBox,GridPane paramGrid){
      ModelController model=new ModelController(null);
      Map<String, Class<?>> ruleParams=model.getParameters("model."+resourcemanager.ResourceManager.getResourceManager().getPm().getResourceMap().get("rules").getString(ruleBox.getValue().toString()));
      int rowIndex=2;
      for(String key: ruleParams.keySet())
      {
          super.componentAdder.makeLabel(paramGrid, 1, rowIndex, key);
          if(ruleParams.get(key).getName()=="model.Article")
              super.componentAdder.makeComboBox(paramGrid, 2, rowIndex++);
          super.componentAdder.makeField(paramGrid, 2, rowIndex++);
          System.out.println(ruleParams.get(key).getName());
      }
     
        
    }
   
}
