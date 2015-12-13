package authoring.ui.editingmenus;

import java.util.List;
import authoring.controller.AuthoringController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
    private Event selectedEvent;
    private Condition selectedCondition;
    private Executable selectedExecutable;
    private GridPane myGridPane;
    private MenuBuilder componentAdder=new MenuBuilder();
        
    public RuleMenuTableConfiguration (AuthoringController controller) {
        myController = controller;
    }

    public void configureTables (GridPane menuPane) {
        
        this.addColumns(eventTable, conditionTable, executableTable);

        addEventTable(menuPane);

        addConditionTable(menuPane);

        addExecutableTable(menuPane);

        ObservableList<Event> eventData =
                FXCollections.observableArrayList((List<Event>)this.myController.callEvent("OtherController","getEventList"));

        eventTable.setItems(eventData);
        
        setTableSelectionListeners();

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
        table.getItems().remove(selectedEvent);
        //List<Event> lister = (List<Event>)this.myController.callEvent("OtherController","getEventList");
        
        List eventList= (List) myController.callEvent("OtherController", "getEventList");

        myController.callEvent("OtherController", "deleteEvent", selectedEvent);
        //lister.remove(selectedEvent);
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
        
        conditionTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        eventTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        conditionTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
    }
    
    
    

    public void setTableSelectionListeners () {
        eventTable.getSelectionModel().selectedItemProperty()
                .addListener( (observableValue, oldValue, newValue) -> {
                    if (eventTable.getSelectionModel().getSelectedItem() != null) {
                        selectedEvent = (Event) newValue;
                        this.updateConditionsAndExecutables(selectedEvent);
                    }
                });

        conditionTable.getSelectionModel().selectedItemProperty()
                .addListener( (observableValue, oldValue, newValue) -> {
                    if (conditionTable.getSelectionModel().getSelectedItem() != null) {
                        selectedCondition = (Condition) newValue;
                    }
                });
        executableTable.getSelectionModel().selectedItemProperty()
                .addListener( (observableValue, oldValue, newValue) -> {
                    if (executableTable.getSelectionModel().getSelectedItem() != null) {
                        selectedExecutable = (Executable) newValue;
                    }
                });
    }

    public void addExecutableTable (GridPane menuPane) {
        componentAdder.makeLabel(menuPane, 5, 1, "Executables");
        menuPane.add(executableTable, 5, 2, 2, 1);
        Button addExecutable = new Button();
        addExecutable.setGraphic(setImagePlus());
        addExecutable
                .setOnAction(e -> new AddProcessMenu("Add Condition", this.myController,
                                                     "Executable", selectedEvent, executableTable));
        menuPane.add(addExecutable, 5, 3);

        Button removeExecutable = new Button();
        removeExecutable.setGraphic(setImageMinus());
        removeExecutable.setOnAction(e -> deleteExecutable(executableTable, selectedEvent, selectedExecutable));
        menuPane.add(removeExecutable, 6, 3);

    }

    public void addConditionTable (GridPane menuPane) {
        componentAdder.makeLabel(menuPane, 3, 1, "Conditions");
        menuPane.add(conditionTable, 3, 2, 2, 1);
        
        Button addCondition = new Button();
        addCondition.setOnAction(e -> new AddProcessMenu("Add Condition", this.myController,
                                                         "Condition", selectedEvent, conditionTable));
        addCondition.setGraphic(setImagePlus());
        menuPane.add(addCondition, 3, 3);

        
        Button removeCondition = new Button();
        removeCondition.setOnAction(e ->deleteCondition(conditionTable, selectedEvent, selectedCondition));
        removeCondition.setGraphic(setImageMinus());
        menuPane.add(removeCondition, 4, 3);

    }

    public void addEventTable (GridPane menuPane) {
        componentAdder.makeLabel(menuPane, 1, 1, "Events");
        menuPane.add(eventTable, 1, 2, 2, 1);

        Button addEvent = new Button();
        addEvent.setOnAction(e -> new AddEventMenu("Add Event", myController, eventTable,
                (List<Event>)this.myController.callEvent("OtherController","getEventList")));
        addEvent.setGraphic(setImagePlus());
        menuPane.add(addEvent, 1, 3);

        Button removeEvent = new Button();
        removeEvent.setOnAction(e -> deleteEvent(eventTable, selectedEvent));
        removeEvent.setGraphic(setImageMinus());
        menuPane.add(removeEvent, 2, 3);
    }

    public void updateConditionsAndExecutables (Event selectedEvent) {
        conditionTable.setItems(null);
        conditionTable.layout();
        ObservableList<Condition> conditionData =
                FXCollections.observableArrayList(selectedEvent.getConditions());
        conditionTable.setItems(conditionData);

        executableTable.setItems(null);
        executableTable.layout();
        ObservableList<Executable> executableData =
                FXCollections.observableArrayList(selectedEvent.getExecutables());
        executableTable.setItems(executableData);

    }


}
