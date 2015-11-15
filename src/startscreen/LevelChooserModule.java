package startscreen;

import javafx.scene.control.Button;

/**
 * Created by Rob on 11/14/15.
 */
public class LevelChooserModule extends AbstractChooserModule {

    public LevelChooserModule(String[] levels){
        super(levels);
    }


    protected void setController(StartScreenController controller, Button b){
        b.setOnAction(e -> controller.setLevel(b.getText()));

    }



}
