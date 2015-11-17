package authoring.ui.smalloverlay;

import authoring.ui.toolbar.ToolbarContainer;
import com.sun.tools.javac.comp.Flow;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
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
        BorderPane ov2 = new BorderPane();
        ToolbarContainer tbc = new ToolbarContainer();
        FlowPane flowTBC = tbc.initializeToolbar();
        ov2.setRight(flowTBC);
        ov2.setMargin(flowTBC, new Insets(0,20,20,20));
        Pane rando = new Pane();
        rando.getStyleClass().add("OverlayP");
        ov2.setLeft(rando);
        //addPane(ov);
        ov2.getStyleClass().add("OverlayP");
        addOverlay(ov2);
    }

}
