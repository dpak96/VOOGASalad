package authoring.ui.toolbar;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;
import authoring.controller.AuthoringController;
import javafx.scene.control.Button;
import resourcemanager.ResourceManager;

public class PlatformOverlay extends ButtonOverlay{

    public PlatformOverlay (AuthoringController authoringController) {
        super(authoringController);
    }

    @Override
    protected List<Button> populateButtonList () {
        List<Button> buttonList = new ArrayList<Button>();
        ResourceBundle platformBundle=(ResourceBundle) ResourceManager.getResourceManager().getResource("PropertiesManager", "platforms");
        Enumeration platformKeys=platformBundle.getKeys();
        while(platformKeys.hasMoreElements()){
            String imageName= (String) platformKeys.nextElement();
            buttonList.add(new PlatformButton(myAuthoringController,imageName));
        }
      
        return buttonList;
    }

}
