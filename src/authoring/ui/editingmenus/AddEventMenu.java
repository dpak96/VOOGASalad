package authoring.ui.editingmenus;

import java.security.NoSuchProviderException;
import java.util.ArrayList;
import authoring.controller.AuthoringController;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import model.Event;
import model.processes.Condition;
import model.processes.Executable;

public class AddEventMenu  extends AuthoringMenu {

    private TextField eventNameField;
    private CheckBox realTimeEvent=new CheckBox();
    
    public AddEventMenu (String title, AuthoringController controller) {
        super(title, controller);
        super.showMenu(300, 300);

    }

    @Override
    public void executeYourMenuFunction () {
        try{
        Event newEvent=new Event(eventNameField.getText(),new ArrayList<Condition>(),new ArrayList<Executable>());
            super.myController.addEventToModel(newEvent, realTimeEvent.isSelected());
                }
        catch(IllegalArgumentException e){
            super.displayErrorMessage();
        }
    }

    @Override
    protected void populateMenu (GridPane menuPane) {

        super.componentAdder.makeLabel(menuPane, 1, 1, "Name :");
        eventNameField=super.componentAdder.makeField(menuPane, 2, 1);
        
        menuPane.add(realTimeEvent, 1, 2);
        this.configureCheckBoxes(realTimeEvent);
        
        
    }

    
    private void configureCheckBoxes(CheckBox realTimeEvent){
        realTimeEvent.setText("Real time event");
       
    }
}
