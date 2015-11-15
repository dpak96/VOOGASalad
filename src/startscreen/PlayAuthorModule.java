package startscreen;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rob on 11/14/15.
 */
public class PlayAuthorModule extends AbstractModule{
    private Button playButton;
    private Button editButton;
    private List<Button> buttons;


    public PlayAuthorModule(){
        super(new HBox());
        buttons = new ArrayList<>();
    }

    public void init(StartScreenController controller){
       buttonSetup();
       addButtons(controller);
    }

    private void buttonSetup(){
        playButton = new Button();
        playButton.setText("Play");
        buttons.add(playButton);
        editButton = new Button();
        editButton.setText("Edit");
        buttons.add(editButton);
    }

    private void addButtons(StartScreenController controller){
        for(Button b: buttons){
            addToContainer(b);
            setController(controller, b);
        }
    }

    private void setController(StartScreenController controller, Button b){
        b.setOnAction(e -> controller.setModeAndAddGame(b.getText()));

    }






}
