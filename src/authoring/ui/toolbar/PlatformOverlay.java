package authoring.ui.toolbar;

import java.util.ArrayList;
import java.util.List;
import authoring.controller.AuthoringController;
import javafx.scene.control.Button;

public class PlatformOverlay extends ButtonOverlay{

    public PlatformOverlay (AuthoringController authoringController) {
        super(authoringController);
    }

    @Override
    protected List<Button> populateButtonList () {
        List<Button> buttonList = new ArrayList<Button>();
        buttonList.add(new PlatformButton(myAuthoringController, "Platform"));
        buttonList.add(new PlatformButton(myAuthoringController, "IceTile"));
        buttonList.add(new PlatformButton(myAuthoringController, "StoneTile"));
        buttonList.add(new PlatformButton(myAuthoringController, "BrickTile"));
        buttonList.add(new PlatformButton(myAuthoringController, "BoneTile"));

        buttonList.add(new EnemyButton(myAuthoringController, "ENEMY"));
        return buttonList;
    }

}
