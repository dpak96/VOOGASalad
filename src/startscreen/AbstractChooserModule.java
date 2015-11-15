package startscreen;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;


public abstract class AbstractChooserModule extends AbstractModule {
    private String[] myObjects;

    public AbstractChooserModule(String[] objs){
        super(new VBox());
        myObjects= objs;
    }

    protected void init(StartScreenController controller){
        for(String gameName: myObjects){
            Button option = new Button(gameName);
            addToContainer(option);
            setController(controller, option);
        }
    }

    protected abstract void setController(StartScreenController controller, Button b);


}
