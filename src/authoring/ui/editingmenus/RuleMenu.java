package authoring.ui.editingmenus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import authoring.controller.AuthoringController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Event;
import model.processes.Condition;
import model.processes.ConditionIsTouching;
import model.processes.Executable;
import model.processes.ExecutableGainLife;
import resourcemanager.ResourceManager;


public class RuleMenu extends AuthoringMenu {

    private HashMap<String, Control> ruleParameters;
    private TableView eventTable = new TableView();
    private TableView conditionTable = new TableView();
    private TableView executableTable = new TableView();
    private Event selectedEvent;
    private Condition selectedCondition;
    private Executable selectedExecutable;
    private RuleMenuTableConfiguration tableConfig =
            new RuleMenuTableConfiguration(this.myController);

    public RuleMenu (String title, AuthoringController controller) {
        super(title, controller);
        super.showMenu(800, 300);

    }

    @Override
    protected void populateMenu (GridPane menuPane) {

        menuPane.setPadding(new Insets(10, 10, 10, 10));
        menuPane.setVgap(10);
        menuPane.setHgap(10);

        addEventTable(menuPane);

        addConditionTable(menuPane);

        addExecutableTable(menuPane);

        tableConfig.configureTables(eventTable, conditionTable, executableTable);

        GridPane paramGrid = new GridPane();
        menuPane.add(paramGrid, 1, 4, 3, 1);

        ObservableList<Event> eventData =
                FXCollections.observableArrayList(super.myController.getEventList());

        eventTable.setItems(eventData);

        setTableSelectionListeners();
        /*
         * conditionTable.getSelectionModel().selectedItemProperty().addListener((observableValue,
         * oldValue, newValue) -> {
         * //Check whether item is selected and set value of selected item to Label
         * if (conditionTable.getSelectionModel().getSelectedItem() != null) {
         * Condition selectedEvent=(Condition) newValue;
         * this.addParameterFields(selectedEvent.getName(),paramGrid);
         * }
         * });
         * 
         * 
         * 
         */

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
        super.componentAdder.makeLabel(menuPane, 5, 1, "Executables");
        menuPane.add(executableTable, 5, 2, 2, 1);
        Button addExecutable = new Button();
        addExecutable.setGraphic(tableConfig.setImagePlus());
        addExecutable
                .setOnAction(e -> new AddProcessMenu("Add Condition", this.myController,
                                                     "Executable", selectedEvent, executableTable,
                                                     selectedEvent.getExecutables()));
        menuPane.add(addExecutable, 5, 3);

        Button removeExecutable = new Button();
        removeExecutable.setGraphic(tableConfig.setImageMinus());
        removeExecutable.setOnAction(e -> executableTable.getItems()
                .remove(executableTable.getSelectionModel().getSelectedItem()));
        menuPane.add(removeExecutable, 6, 3);

    }

    public void addConditionTable (GridPane menuPane) {
        super.componentAdder.makeLabel(menuPane, 3, 1, "Conditions");
        menuPane.add(conditionTable, 3, 2, 2, 1);
        
        Button addCondition = new Button();
        addCondition.setOnAction(e -> new AddProcessMenu("Add Condition", this.myController,
                                                         "Condition", selectedEvent, conditionTable,
                                                         selectedEvent.getConditions()));
        addCondition.setGraphic(tableConfig.setImagePlus());
        menuPane.add(addCondition, 3, 3);

        
        Button removeCondition = new Button();
        removeCondition.setOnAction(e -> conditionTable.getItems().remove(selectedCondition));
        removeCondition.setGraphic(tableConfig.setImageMinus());
        menuPane.add(removeCondition, 4, 3);

    }

    public void addEventTable (GridPane menuPane) {
        super.componentAdder.makeLabel(menuPane, 1, 1, "Events");
        menuPane.add(eventTable, 1, 2, 2, 1);

        Button addEvent = new Button();
        addEvent.setOnAction(e -> new AddEventMenu("Add Event", myController, eventTable,
                                                   myController.getEventList()));
        addEvent.setGraphic(tableConfig.setImagePlus());
        menuPane.add(addEvent, 1, 3);

        Button removeEvent = new Button();
        removeEvent.setOnAction(e -> tableConfig.deleteEvent(eventTable, selectedEvent));
        removeEvent.setGraphic(tableConfig.setImageMinus());
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

    @Override
    public void executeYourMenuFunction () {
        // TODO Auto-generated method stub

    }

}
