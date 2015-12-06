package authoring.ui.editingmenus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import authoring.controller.AuthoringController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.Event;
import model.processes.Condition;
import model.processes.ConditionIsTouching;
import model.processes.Executable;
import model.processes.ExecutableGainLife;
import resourcemanager.ResourceManager;


public class RuleMenu extends AuthoringMenu {

   private HashMap<String,Control> ruleParameters;
   private TableView eventTable=new TableView();
   private TableView conditionTable=new TableView();
   private TableView executableTable=new TableView();



    
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
     menuPane.add(eventTable, 1, 2);
         
     
     super.componentAdder.makeLabel(menuPane, 2, 1 , "Conditions");
     menuPane.add(conditionTable, 2, 2);
     
     super.componentAdder.makeLabel(menuPane, 3, 1, "Executables");
     menuPane.add(executableTable, 3, 2);

     this.addColumns(eventTable, conditionTable, executableTable);
     
     GridPane paramGrid=new GridPane();
     menuPane.add(paramGrid, 1, 4, 3, 1);
     
     
     
     List<Event> eventList=new ArrayList<Event>();
     eventList.add(new Event("MoveHorizontal",new ArrayList<Condition>(),new ArrayList<Executable>()));
     HashMap<String,Object> testMap=new HashMap<String,Object>();
     testMap.put("myName", "2");
     testMap.put("myFirst",null);
     testMap.put("mySecond", null);
     eventList.get(0).getConditions().add(new ConditionIsTouching(testMap));
     
     eventList.get(0).getExecutables().add(new ExecutableGainLife(testMap));
     

     ObservableList<Event> eventData =
             FXCollections.observableArrayList(eventList);
     
     eventTable.setItems(eventData);
     

     
    
     
     eventTable.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
         if (eventTable.getSelectionModel().getSelectedItem() != null) {
             Event selectedEvent=(Event) newValue;
             this.updateConditionsAndExecutables(selectedEvent);
         }
     });
     
     


     
     
   /*  conditionTable.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
         //Check whether item is selected and set value of selected item to Label
         if (conditionTable.getSelectionModel().getSelectedItem() != null) {
             Condition selectedEvent=(Condition) newValue;
             this.addParameterFields(selectedEvent.getName(),paramGrid);
         }
     });*/
     
  

  }
  public void addColumns(TableView eventTable,TableView conditionTable, TableView executableTable){
      
      
      TableColumn condNameCol = new TableColumn("Condition Name");
      condNameCol.setMinWidth(100);
      condNameCol.setCellValueFactory(
              new PropertyValueFactory<Condition, String>("myName"));

      conditionTable.getColumns().add(condNameCol);
      

      TableColumn eventNameCol = new TableColumn("Event Name");
      eventNameCol.setMinWidth(100);
      eventNameCol.setCellValueFactory(
              new PropertyValueFactory<Event, String>("myName"));
      eventTable.getColumns().add(eventNameCol);


      TableColumn execNameCol = new TableColumn("Executable Name");
      execNameCol.setMinWidth(100);
      execNameCol.setCellValueFactory(
              new PropertyValueFactory<Executable, String>("myName"));
      executableTable.getColumns().add(execNameCol);
  }

  public void updateConditionsAndExecutables(Event selectedEvent){
      
      ObservableList<Condition> conditionData =
              FXCollections.observableArrayList(selectedEvent.getConditions());
      conditionTable.setItems(conditionData);
      
      ObservableList<Executable> executableData =
              FXCollections.observableArrayList(selectedEvent.getExecutables());
      executableTable.setItems(executableData);
      
      
  }
 /* public void addParameterFields(String selectedObject, GridPane paramGrid) {
    paramGrid.getChildren().clear();
    ruleParameters = new HashMap<String, Control>();
    ResourceBundle rb =
        (ResourceBundle) ResourceManager.getResourceManager().getResource("PropertiesManager",
                                                                          "rules");
    
    Map<String, Class<?>> ruleParams =
        super.myController
            .getFactoryParameters(("model." +"Executable"+selectedObject));

    int rowIndex = 2;
    for (String key : ruleParams.keySet()) {
      super.componentAdder.makeLabel(paramGrid, 1, rowIndex, key);
      //super.componentAdder.makeLabel(paramGrid, 2, rowIndex++, ruleParams.get(key).toString());
     
    }

  }*/

  @Override
  public void executeYourMenuFunction() {/*
    HashMap<String, Object> parametersToReturn = new HashMap<String, Object>();
    for (String key : ruleParameters.keySet()) {
      if (ruleParameters.get(key) instanceof TextField) {
        TextField parameterField = (TextField) ruleParameters.get(key);
        parametersToReturn.put(key, Double.parseDouble(parameterField.getText()));
      }

    }*/
    // TODO Auto-generated method stub

  }

}
