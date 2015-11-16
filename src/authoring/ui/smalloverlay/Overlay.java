package authoring.ui.smalloverlay;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class Overlay  {
    private Pane p;

    public Overlay(){
        p = new StackPane();
        p.getChildren().add(new Text("Hey There"));
        p.getStyleClass().add("OverlayP");
    }

    public Pane getPane(){
        return p;
    }






}
