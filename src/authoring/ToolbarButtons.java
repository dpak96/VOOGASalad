package authoring;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class ToolbarButtons  extends Button implements IObjectPlacing {

    public ToolbarButtons(){
        this.setPrefHeight(50);
        this.setPrefWidth(50);
    }
    
    public ImageView setImage(String imgName, int width, int height) {
        Image img = new Image(getClass().getClassLoader().getResourceAsStream(imgName));
        ImageView buttonIcon = new ImageView(img);
        buttonIcon.setFitWidth(width);
        buttonIcon.setFitHeight(height);
        return buttonIcon;
}
    
}
