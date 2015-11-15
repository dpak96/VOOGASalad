package authoring.ui.toolbar;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public abstract class ToolbarButtons  extends Button implements IObjectPlacing {

    public ToolbarButtons(){
        this.setPrefHeight(50);
        this.setPrefWidth(50);
        this.setOnAction(e-> placeYourObject());
        this.setEffect(configureShadowEffect());
    }
    
    private DropShadow configureShadowEffect(){
        DropShadow buttonEffect=new DropShadow();
        buttonEffect.setColor(Color.BLACK);
        return buttonEffect;
    }
    public ImageView setImage(String imgName, int width, int height) {
        Image img = new Image(getClass().getClassLoader().getResourceAsStream("resources/images/"+imgName));
        ImageView buttonIcon = new ImageView(img);
        buttonIcon.setFitWidth(width);
        buttonIcon.setFitHeight(height);
        return buttonIcon;
}
    
}
