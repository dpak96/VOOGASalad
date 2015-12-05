package authoring.ui.editingmenus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import authoring.controller.AuthoringController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.Event;
import model.article.Article;
import model.controller.ModelController;
import resourcemanager.ResourceManager;


public class RuleMenu extends AuthoringMenu {

    HashMap<String,Control> ruleParameters;
    
    public RuleMenu (String title, AuthoringController controller) {
        super(title,controller);
        super.showMenu(500, 300);
        
    }
    

 
  @Override
  protected void populateMenu(GridPane menuPane) {
      
      menuPane.setPadding(new Insets(10,10, 10, 10));
      menuPane.setVgap(10);
      menuPane.setHgap(10);
   
     super.componentAdder.makeLabel(menuPane, 1, 1 , "Events");
     TableView eventTable=new TableView();
     menuPane.add(eventTable, 1, 2);
         
     
     super.componentAdder.makeLabel(menuPane, 2, 1 , "Conditions");
     TableView conditionTable=new TableView();
     menuPane.add(conditionTable, 2, 2);
     
     super.componentAdder.makeLabel(menuPane, 3, 1, "Executables");
     TableView executableTable=new TableView();
     menuPane.add(executableTable, 3, 2);

     GridPane paramGrid=new GridPane();
     menuPane.add(paramGrid, 1, 4, 3, 1);
     
     TableColumn firstNameCol = new TableColumn("Event Name");
     firstNameCol.setMinWidth(100);
     firstNameCol.setCellValueFactory(
             new PropertyValueFactory<Event, String>("myName"));
     eventTable.getColumns().add(firstNameCol);
     //firstNameCol.setPrefWidth(eventTable.getPrefWidth()-2);
     
     List<Event> eventList=this.myController.getEventList();
     eventList.add(new Event("MoveHorizontal",null,null));
     
     ObservableList<Event> data =
             FXCollections.observableArrayList(eventList);
     System.out.println(data.size());
     eventTable.setItems(data);
     
     
     /*
    super.componentAdder.makeLabel(menuPane, 1, 1, "Rule Type: ");
    ComboBox ruleTypeBox = new ComboBox();
    menuPane.add(ruleTypeBox, 2, 1);
    ruleTypeBox.getItems().add("Gravity");
    ruleTypeBox.getItems().add("MoveRight");
    GridPane paramGrid = new GridPane();
    ruleTypeBox.setOnAction(e -> addParameterFields(ruleTypeBox, paramGrid));
    menuPane.add(paramGrid, 1, 2, 2, 1);*/
    

  }

  public void addParameterFields(String selectedObject, GridPane paramGrid) {
    paramGrid.getChildren().clear();
    ruleParameters = new HashMap<String, Control>();
    ResourceBundle rb =
        (ResourceBundle) ResourceManager.getResourceManager().getResource("PropertiesManager",
                                                                          "rules");
    
    Map<String, Class<?>> ruleParams =
        super.myController
            .getFactoryParameters(("model." + rb.getString(selectedObject)));

    int rowIndex = 2;
    for (String key : ruleParams.keySet()) {
      super.componentAdder.makeLabel(paramGrid, 1, rowIndex, key);
      if (ruleParams.get(key).getName() == "model.Article")
        ruleParameters.put(key, (super.componentAdder.makeComboBox(paramGrid, 2, rowIndex++)));
      else
        ruleParameters.put(key, (super.componentAdder.makeField(paramGrid, 2, rowIndex++)));
    }

  }

  @Override
  public void executeYourMenuFunction() {
    HashMap<String, Object> parametersToReturn = new HashMap<String, Object>();
    for (String key : ruleParameters.keySet()) {
      if (ruleParameters.get(key) instanceof TextField) {
        TextField parameterField = (TextField) ruleParameters.get(key);
        parametersToReturn.put(key, Double.parseDouble(parameterField.getText()));
      }

    }
    // TODO Auto-generated method stub

  }

}
