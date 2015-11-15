package startscreen;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Created by Rob on 11/14/15.
 */
public class GameChooserModule extends AbstractChooserModule {

    public GameChooserModule(String[] games){
        super(games);
    }

    protected void setController(StartScreenController controller, Button b){
        b.setOnAction(e -> controller.setGameAndAddLevel(b.getText()));
    }
}
