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
    private CheckBox collisionEvent=new CheckBox();
    private CheckBox buttonEvent=new CheckBox();
    
    public AddEventMenu (String title, AuthoringController controller) {
        super(title, controller);
        super.showMenu(300, 300);

    }

    @Override
    public void executeYourMenuFunction () {
        try{
        Event newEvent=new Event(eventNameField.getText(),new ArrayList<Condition>(),new ArrayList<Executable>());
        if(realTimeEvent.isSelected()){
            
        }
            ///super.myController
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
        menuPane.add(collisionEvent, 1, 3);
        menuPane.add(buttonEvent, 1, 4);
        
        this.configureCheckBoxes(realTimeEvent, collisionEvent, buttonEvent);
        
    }

    
    private void configureCheckBoxes(CheckBox realTimeEvent, CheckBox collisionEvent,CheckBox buttonEvent){
        realTimeEvent.setText("Real time event");
        collisionEvent.setText("Collision event");
        buttonEvent.setText("Button press event");
    }
}
