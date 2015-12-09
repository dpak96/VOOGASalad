package authoring.ui.editingmenus;

import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import authoring.controller.AuthoringController;
import javafx.collections.FXCollections;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Event;
import model.processes.Condition;
import model.processes.Executable;
import resourcemanager.ResourceManager;


public class AddEventMenu extends AuthoringMenu {

    private TextField eventNameField;
    private ComboBox<String> eventType;
    private TableView myEventTable;
    private List<Event> myEventList;
    private RuleMenuTableConfiguration tableConfig=new RuleMenuTableConfiguration(this.myController);
    private Map<String,Control> fieldMap=new HashMap<String,Control>();

    
    private  Map<String,String> eventParams=new HashMap<String,String>();

    
    public AddEventMenu (String title, AuthoringController controller, TableView eventTable,  List<Event> tableList) {
        super(title, controller);
        myEventTable = eventTable;
        myEventList=tableList;
        super.showMenu(300, 300);

    }

    @Override
    public void executeYourMenuFunction () {
        for(String key: fieldMap.keySet())
        {
            if(fieldMap.get(key) instanceof TextField)
            {   TextField field=(TextField) fieldMap.get(key);
                eventParams.put(key,field.getText());
            }
            if(fieldMap.get(key) instanceof ComboBox)
            {
                ComboBox box=(ComboBox) fieldMap.get(key);
                eventParams.put(key,box.getValue().toString());
            }
        }
        try {
            Event newEvent =
                    new Event(eventNameField.getText(), new ArrayList<Condition>(),
                              new ArrayList<Executable>());
            myController.callEvent("OtherController","addEventToModel",newEvent, eventType.getValue(),eventParams);
        }
        catch (IllegalArgumentException e) {
            super.displayErrorMessage();
        }
        
        System.out.println("refresh");
        tableConfig.refreshTable(myEventTable, myEventList);
    }

    @Override
    protected void populateMenu (GridPane menuPane) {

        super.componentAdder.makeLabel(menuPane, 1, 1, "New Event Name :");
        eventNameField = super.componentAdder.makeField(menuPane, 2, 1);
        
        super.componentAdder.makeLabel(menuPane, 1, 2, "Event Type");
        eventType=super.componentAdder.makeComboBox(menuPane, 2, 2);
        eventType.getItems().addAll(Arrays.asList("Ordinary","Active","Collision","Button"));
        
        GridPane paramGrid= new GridPane();
        menuPane.add(paramGrid, 1, 3,2,2);
       
        eventType.setOnAction(e-> this.populateEventParameters(paramGrid,eventType.getValue(),eventParams));

    }
    
    private void populateEventParameters(GridPane paramGrid,String eventSelection,Map<String,String> eventParams){
        
        EventParameters  paramFiller=new EventParameters(super.myController);
        paramGrid.getChildren().clear();
        fieldMap.clear();
        
       if( eventType.getValue().equals("Collision"))
           fieldMap=paramFiller.populateCollisionEventParameters(paramGrid);
       if(eventType.getValue().equals("Button"))
           fieldMap=paramFiller.populateButtonEventParameters(paramGrid);
       
     
        
    }

    
  
}
