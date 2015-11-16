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
        myContainer.setId("PE");
        buttons = new ArrayList<>();
    }

    public void init(StartScreenController controller){
       buttonSetup();
       addButtons(controller);
    }

    private void buttonSetup(){
        buttons.add(buttonCreator("Play"));
        buttons.add(buttonCreator("Edit"));
    }


    private Button buttonCreator(String name){
        Button genButton = new Button();
        genButton.setText(name);
        genButton.setId("PAButton");
        return genButton;
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
