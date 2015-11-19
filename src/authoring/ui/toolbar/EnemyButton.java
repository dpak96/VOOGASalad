package authoring.ui.toolbar;

import authoring.controller.AuthoringController;
import authoring.ui.draganddrop.DraggableElement;
import authoring.ui.smalloverlay.OverlayController;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class EnemyButton extends ToolbarButton{
  private final String NAME = "ENEMY";


    public EnemyButton (AuthoringController myController) {
        super(myController);
        this.setGraphic(super.setImage(super.toolbarProperties.getString(NAME)));
        this.setName(NAME);
        this.setImageName(super.toolbarProperties.getString(NAME));

    }

    @Override
    public void placeYourObject () {

        ButtonOverlay bo = new ButtonOverlay(myController);
        OverlayController oc = (OverlayController) this.getParent().getParent();
        oc.addOverlay(bo.init());
        bo.init2();
        
    }




    
    

   
}
