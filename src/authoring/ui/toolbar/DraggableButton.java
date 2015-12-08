package authoring.ui.toolbar;

import authoring.ui.draganddrop.DraggableElement;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import resourcemanager.ResourceManager;

public class DraggableButton  extends DraggableElement {
    
    private static final int BUTTON_DIMENSION=50;
    
    public DraggableButton(String imgName){
        this.intialize(imgName);
        super.name=imgName;
        super.imageName=imgName;
             
    }
   private void intialize(String imgName){
       super.dragDetected();
       this.setPrefSize(BUTTON_DIMENSION, BUTTON_DIMENSION);
        super.setGraphic(this.setImage(imgName));
   }

    protected ImageView setImage(String imgName){
        ImageView buttonIcon = new ImageView((Image) ResourceManager.getResourceManager().getResource("ImageManager", imgName));
        buttonIcon.setFitWidth(this.getPrefWidth());
        buttonIcon.setFitHeight(this.getPrefHeight());
        return buttonIcon;
    }
}
