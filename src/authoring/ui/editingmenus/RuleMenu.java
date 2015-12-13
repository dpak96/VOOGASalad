//This entire file is part of my masterpiece
//Jasper Hancock


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

    private RuleMenuTableConfiguration tableConfig ;
    private static final int MENU_WIDTH = 800;
    private static final int MENU_HEIGHT = 300;
    public RuleMenu (String title, AuthoringController controller) {
        super(title, controller, MENU_WIDTH, MENU_HEIGHT);
    }

    public  void populateMenu (GridPane menuPane) {

        menuPane.setPadding(new Insets(10, 10, 10, 10));
        menuPane.setVgap(10);
        menuPane.setHgap(10);

        tableConfig=new RuleMenuTableConfiguration(super.myController);
        tableConfig.configureTables(menuPane);

    }

    
    public void executeYourMenuFunction () {
        // The functions of this menu are done by its tables, no need to act on "OK" press

    }

}
