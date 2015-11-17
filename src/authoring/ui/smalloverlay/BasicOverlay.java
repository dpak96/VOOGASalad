package authoring.ui.smalloverlay;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import uibasics.Layout;

public class BasicOverlay extends OverlayController {

    public BasicOverlay() {
        super();

    }

    public void init(Layout basics) {
        addPane(basics);
    }

}
