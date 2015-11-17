package authoring.ui.toolbar;

import authoring.ui.draganddrop.DraggableElement;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import resourcemanager.ResourceManager;

public abstract class ToolbarButtons  extends DraggableElement implements IObjectPlacing {
    ResourceManager resources=new ResourceManager();
    
    public ToolbarButtons(){
        this.setPrefHeight(50);
        this.setPrefWidth(50);
        super.dragDetected();
        super.dragEnd();
       // this.setOnAction(e-> placeYourObject());
        this.setEffect(configureShadowEffect());
    }
    
    private DropShadow configureShadowEffect(){
        DropShadow buttonEffect=new DropShadow();
        buttonEffect.setColor(Color.BLACK);
        return buttonEffect;
    }
    
    public ImageView setImage(String imgName, int width, int height) {
        resources.getIm().getImageMap().get(imgName);
        ImageView buttonIcon = new ImageView(resources.getIm().getImageMap().get(imgName));
        buttonIcon.setFitWidth(width);
        buttonIcon.setFitHeight(height);
        return buttonIcon;
}
    
}
