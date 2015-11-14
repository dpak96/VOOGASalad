package authoring;

import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


public class ToolbarContainer extends Application {

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
        return buttonList;
    }

    public static void main (String args[]) {
        launch(args);

    }

    @Override
    public void start (Stage arg0) throws Exception {
        ToolbarContainer tester = new ToolbarContainer();
        BorderPane testLayout=new BorderPane();
        testLayout.setRight(tester.initializeToolbar());
        testLayout.setLeft(new HBox());
        Scene testScene = new Scene(testLayout);
        
        arg0.setScene(testScene);
        arg0.show();

    }
}
