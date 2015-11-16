package authoring.ui.toolbar;

import authoring.ui.propertyeditor.EnemyProperties;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlatformButton extends ToolbarButtons{

    public PlatformButton () {
        super();
        this.setGraphic(this.setImage("Platform.png", 50, 50));
    }

    @Override
    public void placeYourObject () {
            
            EnemyProperties propTest=new EnemyProperties();
            propTest.showMenu();
    }

   
    
    
}
