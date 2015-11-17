package authoring.ui.smalloverlay;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class OverlayControllerEx extends OverlayController {

    public OverlayControllerEx() {
        super();

    }

    public void init() {
        //Button button = new Button("Switch");
        Pane ov = new StackPane();
        Pane ov2 = new StackPane();
        //addPane(ov);
        ov2.getChildren().add(new Text("Hi"));
        ov2.getStyleClass().add("OverlayP");
        addOverlay(ov2);
    }

}
