package authoring.ui.toolbar;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ResourceBundle;
import authoring.controller.AuthoringController;
import javafx.scene.control.Button;
import resourcemanager.ResourceManager;

public class EnemyOverlay extends ButtonOverlay{

    public EnemyOverlay (AuthoringController authoringController) {
        super(authoringController);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected List<Button> populateButtonList () {
        List<Button> buttonList=new ArrayList<Button>();
        for(String imgName: ResourceManager.getResourceManager().getResourceMap("ArticleImageManager").keySet()){
            buttonList.add(new DraggablePlatformButton(imgName));
        }
        return buttonList;
    }

}
