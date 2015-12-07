package authoring.ui.toolbar;

import java.util.ResourceBundle;
import authoring.controller.AuthoringController;
import authoring.ui.draganddrop.DraggableElement;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import resourcemanager.ResourceManager;


public abstract class ToolbarButton  extends DraggableElement implements IObjectPlacing {
   protected ResourceBundle toolbarProperties=(ResourceBundle) ResourceManager.getResourceManager().getResource("PropertiesManager", "toolbar");
   
   private final int BUTTON_DIMENSION=50;
   public AuthoringController myController;
   
    public ToolbarButton(AuthoringController authoringController){
        myController=authoringController;
        this.setPrefSize(BUTTON_DIMENSION, BUTTON_DIMENSION);
        super.dragDetected();
        //super.dragEnd();
        this.setOnAction(e-> placeYourObject());
        this.setEffect(configureShadowEffect());
    }
    
    private DropShadow configureShadowEffect(){
        DropShadow buttonEffect=new DropShadow();
        buttonEffect.setColor(Color.BLACK);
        return buttonEffect;
    }
    
    protected ImageView setImage(String imgName) {
        ImageView buttonIcon = new ImageView((Image) ResourceManager.getResourceManager().getResource("ImageManager", imgName));
        buttonIcon.setFitWidth(this.getPrefWidth());
        buttonIcon.setFitHeight(this.getPrefHeight());
        return buttonIcon;
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
