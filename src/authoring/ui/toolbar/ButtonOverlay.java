package authoring.ui.toolbar;

import java.util.ArrayList;
import java.util.List;
import authoring.ui.draganddrop.DraggableElement;
import authoring.ui.smalloverlay.OverlayController;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;


public class ButtonOverlay extends DraggableElement {
        private OverlayController myOverlayController;
        private FlowPane myToolBox;

        public ButtonOverlay(){
            myToolBox = new FlowPane();
            myOverlayController = new OverlayController();
        }

        public Pane init() {
            myToolBox = new FlowPane();
            configureToolBox(myToolBox);
            // toolBox.getChildren().add(new PlatformSelector());
            myToolBox.getChildren().addAll(populateButtonList());
            //myToolBox.setPrefSize(600,200);
            return myToolBox;
        }
        private void configureToolBox (FlowPane toolBox) {
        }

        private List<Button> populateButtonList () {
            List<Button> buttonList = new ArrayList<Button>();
            buttonList.add(new RuleButton());
            buttonList.add(new EnemyButton());
            return buttonList;
        }




    }
