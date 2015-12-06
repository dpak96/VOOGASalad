package startscreen;

import javafx.scene.control.Button;

/**
 * Created by Rob on 11/14/15.
 */
public class LevelChooserModule extends AbstractChooserModule {

    public LevelChooserModule(String[] levels){
        super(levels);
        myContainer.setId("LevelS");

    }

    @Override
    protected void init(StartScreenController controller, String mode){
        super.init(controller, mode);
        if(mode.equals("edit")){
        	Button newLevel = new Button("New Level");
        	buttons.add(newLevel);
        	addToContainer(newLevel);
        	int size = buttons.size();
        	newLevel.setOnAction(e->controller.setNewLevel());
        }
        setButtonID();
    }

    private void setButtonID(){
        for(Button b: buttons){
            b.setId("LButton");
        }
    }


    protected void setController(StartScreenController controller, Button b){
        b.setOnAction(e -> controller.setLevel(b.getText() + ".xml"));
    }

}
