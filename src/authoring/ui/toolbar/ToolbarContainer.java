package authoring.ui.toolbar;

import java.util.ArrayList;
import java.util.List;
import authoring.controller.AuthoringController;
import authoring.ui.draganddrop.DraggableElement;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;


public class ToolbarContainer extends DraggableElement {
    AuthoringController myController;
    public ToolbarContainer(AuthoringController authoringController){
        myController=authoringController;
    }

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
        buttonList.add(new PlatformButton(myController, "Platform"));
        buttonList.add(new EnemyButton(myController, "Goomba"));
        buttonList.add(new CheckpointButton(myController));
        buttonList.add(new BackgroundButton(myController));
        buttonList.add(new ControlButton(myController));
        buttonList.add(new RuleButton(myController));
        buttonList.add(new RandomButton(myController));
        return buttonList;
    }
    
 

   
}
