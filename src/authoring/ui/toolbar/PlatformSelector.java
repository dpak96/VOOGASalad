package authoring.ui.toolbar;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class PlatformSelector extends ComboBox<PlatformButton> {
    
    public PlatformSelector(){
        
        ComboBox<PlatformButton> platformOptions=new ComboBox<PlatformButton>();
        for(int x=0;x<3;x++)
        this.getItems().add(new PlatformButton());      
        this.setOnAction(e -> {
            System.out.println("asds");
            this.getValue().placeYourObject();
        });
    }
    

    
}
