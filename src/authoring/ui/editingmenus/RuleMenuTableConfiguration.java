package authoring.ui.editingmenus;

import java.util.List;
import authoring.controller.AuthoringController;
import javafx.collections.FXCollections;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import model.Event;
import model.processes.Condition;
import model.processes.Executable;
import resourcemanager.ResourceManager;


public class RuleMenuTableConfiguration {

    private TableView eventTable = new TableView();
    private TableView conditionTable = new TableView();
    private TableView executableTable = new TableView();
    private AuthoringController myController;

    public RuleMenuTableConfiguration (AuthoringController controller) {
        myController = controller;
    }

    public void configureTables (TableView eventTable,
                                 TableView conditionTable,
                                 TableView executableTable) {

        this.addColumns(eventTable, conditionTable, executableTable);

    }
  
    
    public ImageView setImagePlus() {
        ImageView buttonIcon = new ImageView((Image) ResourceManager.getResourceManager().getResource("ImageManager", "plus"));
        buttonIcon.setFitWidth(20);
        buttonIcon.setFitHeight(20);
        return buttonIcon;
}
    public ImageView setImageMinus() {
        ImageView buttonIcon = new ImageView((Image) ResourceManager.getResourceManager().getResource("ImageManager", "minus"));
        buttonIcon.setFitWidth(20);
        buttonIcon.setFitHeight(20);
        return buttonIcon;
}

    public void refreshTable (TableView table, List<?> tableList) {
        table.setItems(null);
        table.layout();
        table.setItems(FXCollections.observableArrayList(tableList));
    }

    public void deleteEvent (TableView table, Event selectedEvent) {
        System.out.println("dasd");
        table.getItems().remove(selectedEvent);
        myController.getEventList().remove(selectedEvent);
        this.refreshTable(table, table.getItems());

    }

    public void deleteCondition (TableView table,
                                 Event selectedEvent,
                                 Condition selectedCondition) {
        table.getItems().remove(selectedCondition);
        selectedEvent.getConditions().remove(selectedCondition);
        this.refreshTable(table, table.getItems());

    }

    public void deleteExecutable (TableView table,
                                  Event selectedEvent,
                                  Executable selectedExecutable) {
        table.getItems().remove(selectedExecutable);
        selectedEvent.getExecutables().remove(selectedExecutable);
        this.refreshTable(table, table.getItems());
    }

    private void addColumns (TableView eventTable,
                             TableView conditionTable,
                             TableView executableTable) {

        TableColumn condNameCol = new TableColumn("Condition Name");
     //   condNameCol.setMinWidth(100);
        condNameCol.setCellValueFactory(
                                        new PropertyValueFactory<Condition, String>("myName"));

        conditionTable.getColumns().add(condNameCol);

        TableColumn eventNameCol = new TableColumn("Event Name");
      //  eventNameCol.setMinWidth(100);
        eventNameCol.setCellValueFactory(
                                         new PropertyValueFactory<Event, String>("myName"));
        eventTable.getColumns().add(eventNameCol);

        TableColumn execNameCol = new TableColumn("Executable Name");
       // execNameCol.setMinWidth(100);
        execNameCol.setCellValueFactory(
                                        new PropertyValueFactory<Executable, String>("myName"));
        executableTable.getColumns().add(execNameCol);
    }

}
