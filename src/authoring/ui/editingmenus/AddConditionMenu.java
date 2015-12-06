package authoring.ui.editingmenus;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import authoring.controller.AuthoringController;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.layout.GridPane;
import resourcemanager.ResourceManager;


public class AddConditionMenu extends AuthoringMenu {
    ComboBox<String>  conditionBox= new ComboBox<String>();
    Map<String, Control> parameters = new HashMap<String, Control>();

    public AddConditionMenu (String title, AuthoringController controller) {
        super(title, controller);
        super.showMenu(300, 300);
    }

    @Override
    public void executeYourMenuFunction () {
        // TODO Auto-generated method stub

    }

    @Override
    protected void populateMenu (GridPane menuPane) {

        super.componentAdder.makeLabel(menuPane, 1, 1, "Condition:");
        menuPane.add(conditionBox, 2, 1);
        GridPane paramGrid=new GridPane();
        menuPane.add(paramGrid, 1, 2,2,2);
        this.addCondition(conditionBox,paramGrid);

    }
    
    public void addCondition(ComboBox<String> conditionBox,GridPane paramGrid){
       ResourceBundle conditionBundle=(ResourceBundle) ResourceManager.getResourceManager().getResource("PropertiesManager", "ConditionSubclass");
       Enumeration bundleKeys=conditionBundle.getKeys();
       while(bundleKeys.hasMoreElements()){
           String className=(String) bundleKeys.nextElement();
           conditionBox.getItems().add(className);
       }
       conditionBox.setOnAction(e-> this.addParameterFields(conditionBox.getValue(), paramGrid));
    }
    
    public void addParameterFields (String selectedObject, GridPane paramGrid) {
        paramGrid.getChildren().clear();
        System.out.println("asd");
        Map<String, Class<?>> ruleParams =
                super.myController
                        .getFactoryParameters(("model.processes." + "Condition" + selectedObject));

        int rowIndex = 2;
        for (String key : ruleParams.keySet()) {
            super.componentAdder.makeLabel(paramGrid, 1, rowIndex, key);
            super.componentAdder.makeField(paramGrid, 2, rowIndex++);
          /*  super.componentAdder.makeLabel(paramGrid, 2, rowIndex++,
                                           ruleParams.get(key).toString());*/

        }

    }

}
