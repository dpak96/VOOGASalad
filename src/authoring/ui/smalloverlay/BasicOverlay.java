package authoring.ui.smalloverlay;

import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import uibasics.UICore;

public class BasicOverlay extends OverlayController {

    public BasicOverlay() {
        super();

    }

    public void init(UICore basics) {
        addPane(basics);
    }

}
