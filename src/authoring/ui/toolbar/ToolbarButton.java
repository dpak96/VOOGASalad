package authoring.ui.toolbar;

import java.util.ResourceBundle;
import authoring.ui.draganddrop.DraggableElement;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import resourcemanager.ResourceManager;

public abstract class ToolbarButton  extends DraggableElement implements IObjectPlacing {
    ResourceManager resources=new ResourceManager();
    ResourceBundle toolbarProperties=ResourceBundle.getBundle("properties.toolbar");
    
    public ToolbarButton(){
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
    
    protected ImageView setImage(String imgName) {
        resources.getIm().getImageMap().get(imgName);
        ImageView buttonIcon = new ImageView(resources.getIm().getImageMap().get(imgName));
        buttonIcon.setFitWidth(this.getPrefWidth());
        buttonIcon.setFitHeight(this.getPrefHeight());
        return buttonIcon;
}
    
}
