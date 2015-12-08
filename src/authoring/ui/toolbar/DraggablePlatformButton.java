package authoring.ui.toolbar;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import resourcemanager.ResourceManager;

public class DraggablePlatformButton extends DraggableButton{

    public DraggablePlatformButton (String imgName) {
        super(imgName);
        // TODO Auto-generated constructor stub
    }

    @Override
    protected ImageView getImage (String imgName) {
       ImageView buttonImage= new ImageView((Image) ResourceManager.getResourceManager().getResource("ImageManager", imgName));
       return buttonImage;
    }
    
    

}
