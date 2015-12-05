package authoring.ui.toolbar;

import java.util.ArrayList;
import java.util.List;
import authoring.controller.AuthoringController;
import javafx.scene.control.Button;

public class EnemyOverlay extends ButtonOverlay{

    public EnemyOverlay (AuthoringController authoringController) {
        super(authoringController);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected List<Button> populateButtonList () {
        List<Button> buttonList=new ArrayList<Button>();
        buttonList.add(new EnemyButton(super.myAuthoringController,"Vegeta"));

        return buttonList;
    }

}
