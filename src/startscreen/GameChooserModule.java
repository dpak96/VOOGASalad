package startscreen;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class GameChooserModule extends AbstractChooserModule {

    public GameChooserModule(String[] games){
        super(games);
        myContainer.setId("GameS");
    }

    @Override
    protected void init(StartScreenController controller, String mode){
        super.init(controller, mode);
        if(mode.equals("edit")){
        	Button newGame = new Button("New Game");
        	buttons.add(newGame);
        	addToContainer(newGame);
        	newGame.setOnAction(e->controller.newGame("1"));
        }
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
