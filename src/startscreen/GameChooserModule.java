package startscreen;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class GameChooserModule extends AbstractChooserModule {

    public GameChooserModule(String[] games){
        super(games);
        myContainer.setId("GameS");
    }

    @Override
    protected void init(StartScreenController controller){
        super.init(controller);
        setButtonID();
    }

    private void setButtonID(){
        for(Button b: buttons){
            b.setId("GButton");
        }
    }


    protected void setController(StartScreenController controller, Button b){
        b.setOnAction(e -> controller.setGameAndAddLevel(b.getText()));
    }
}
