package authoring.ui.toolbar;

import java.util.ArrayList;
import java.util.List;
import authoring.controller.AuthoringController;
import javafx.scene.control.Button;
import resourcemanager.ResourceManager;

public class PortalOverlay extends ButtonOverlay {

    public PortalOverlay (AuthoringController authoringController) {
        super(authoringController);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected List<Button> populateButtonList () {
        List<Button> buttonList=new ArrayList<Button>();
        for(String imgName: ResourceManager.getResourceManager().getResourceMap("ImageManager").keySet()){
            if(imgName.contains("door"))
            buttonList.add(new DraggablePlatformButton(imgName));
        }
        
        return buttonList;
    }
    

}
