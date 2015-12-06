package authoring.ui.editingmenus;

import java.security.NoSuchProviderException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import authoring.controller.AuthoringController;
import javafx.collections.FXCollections;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
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
    private RuleMenuTableConfiguration tableConfig=new RuleMenuTableConfiguration();
    private  Map<String,String> eventParams=new HashMap<String,String>();

    public AddEventMenu (String title, AuthoringController controller, TableView eventTable,  List<Event> tableList) {
        super(title, controller);
        myEventTable = eventTable;
        myEventList=tableList;
        super.showMenu(300, 300);

    }

    @Override
    public void executeYourMenuFunction () {
        try {
            Event newEvent =
                    new Event(eventNameField.getText(), new ArrayList<Condition>(),
                              new ArrayList<Executable>());
            super.myController.addEventToModel(newEvent, eventType.getValue(),eventParams);
        }
        catch (IllegalArgumentException e) {
            super.displayErrorMessage();
        }
        
        
        tableConfig.refreshTable(myEventTable, myEventList);
    }

    @Override
    protected void populateMenu (GridPane menuPane) {

        super.componentAdder.makeLabel(menuPane, 1, 1, "Name :");
        eventNameField = super.componentAdder.makeField(menuPane, 2, 1);
        
        eventType=new ComboBox();
        eventType.getItems().add("Ordinary");
        eventType.getItems().add("Active");
        eventType.getItems().add("Collision");
        eventType.getItems().add("Button");
        menuPane.add(eventType, 1, 2);
        
        

    }

    
  
}
