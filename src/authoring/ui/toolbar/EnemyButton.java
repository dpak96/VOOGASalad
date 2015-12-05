package authoring.ui.toolbar;

import authoring.controller.AuthoringController;
import authoring.ui.draganddrop.DraggableElement;
import authoring.ui.smalloverlay.OverlayController;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class EnemyButton extends ToolbarButton{
  private final String NAME;


    public EnemyButton (AuthoringController myController, String imageName) {
        super(myController);
        NAME=imageName;
        this.setGraphic(super.setImage(NAME));
        this.setName(NAME);
        this.setImageName(NAME);

    }

    @Override
    public void placeYourObject () {

        ButtonOverlay bo = new EnemyOverlay(myController);
        OverlayController oc = (OverlayController) this.getParent().getParent();
        oc.addOverlay(bo.init());
        bo.init2();
        
    }




    
    

   
}
