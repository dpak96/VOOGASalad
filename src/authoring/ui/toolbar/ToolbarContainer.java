package authoring.ui.toolbar;

import java.util.ArrayList;
import java.util.List;
import authoring.ui.draganddrop.DraggableElement;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class ToolbarContainer extends DraggableElement {

    public FlowPane initializeToolbar () {
        FlowPane toolBox = new FlowPane();
        configureToolBox(toolBox);
        toolBox.getChildren().addAll(populateButtonList());

        return toolBox;

    }

    private void configureToolBox (FlowPane toolBox) {

        toolBox.setPadding(new Insets(10, 10, 10, 10));
        toolBox.setVgap(4);
        toolBox.setHgap(4);
        toolBox.setPrefWrapLength(200);
        toolBox.setPrefWidth(170);
    }

    private List<Button> populateButtonList () {
        List<Button> buttonList = new ArrayList<Button>();
        buttonList.add(new PlatformButton());
        buttonList.add(new EnemyButton());
        buttonList.add(new CheckpointButton());
        buttonList.add(new BackgroundButton());
        buttonList.add(new ControlButton());
        buttonList.add(new RuleButton());
        return buttonList;
    }
    
 

   
}
