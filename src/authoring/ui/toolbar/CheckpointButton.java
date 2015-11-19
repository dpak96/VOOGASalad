package authoring.ui.toolbar;

import javafx.scene.control.Button;

public class CheckpointButton extends ToolbarButton {

    public CheckpointButton () {
        super();
        this.setGraphic(super.setImage(super.toolbarProperties.getString("CHECKPOINT")));
        
    }

    @Override
    public void placeYourObject () {
        // TODO Auto-generated method stub
        
    }

    
}
