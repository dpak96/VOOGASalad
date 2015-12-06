package authoring.ui.editingmenus;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Event;
import model.processes.Condition;
import model.processes.Executable;

public class RuleMenuTableConfiguration {
    

    private TableView eventTable = new TableView();
    private TableView conditionTable = new TableView();
    private TableView executableTable = new TableView();
    
    public void configureTables(TableView eventTable,
                                TableView conditionTable,
                                TableView executableTable)
    {
        
        this.addColumns(eventTable, conditionTable, executableTable);
        
    }
    
    private void addColumns (TableView eventTable,
                            TableView conditionTable,
                            TableView executableTable) {

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


}
