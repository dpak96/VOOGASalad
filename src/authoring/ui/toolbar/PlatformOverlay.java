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
        for(String imageName: ResourceManager.getResourceManager().getResourceMap("PlatformImageManager").keySet()){
            buttonList.add(new DraggablePlatformButton(imageName));
        }
      
        return buttonList;
    }
    public String getImageName() {
        return imageName;
      }

      public void setImageName(String imageName) {
        this.imageName = imageName;
      }

      public String getName() {
        return name;
      }

      public void setName(String name) {
        this.name = name;
      }
      

}
