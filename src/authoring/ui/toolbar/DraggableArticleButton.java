package authoring.ui.toolbar;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import resourcemanager.ResourceManager;

public class DraggableArticleButton extends DraggableButton{

    public DraggableArticleButton (String imgName) {
        super(imgName);
    }

    @Override
    protected ImageView getImage (String imgName) {
        // TODO Auto-generated method stub
        ImageView buttonImage= new ImageView((Image) ResourceManager.getResourceManager().getResource("ArticleImageManager", imgName));
        return buttonImage;
    }

}
