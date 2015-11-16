package startscreen;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.util.ArrayList;


public abstract class AbstractChooserModule extends AbstractModule {
    private String[] myObjects;
    protected ArrayList<Button> buttons;

    public AbstractChooserModule(String[] objs){
        super(new VBox());
        myObjects= objs;
        buttons = new ArrayList<>();
    }

    protected void init(StartScreenController controller){
        for(String gameName: myObjects){
            Button option = new Button(gameName);
            buttons.add(option);
            addToContainer(option);
            setController(controller, option);
        }
    }

    protected abstract void setController(StartScreenController controller, Button b);


}
