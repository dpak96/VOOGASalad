package authoring.ui.toolbar;

import authoring.ui.AuthoringUI;
import authoring.ui.editingmenus.EnemyProperties;
import authoring.ui.smalloverlay.OverlayController;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlatformButton extends ToolbarButton{

    public PlatformButton () {
        super();
        this.setGraphic(super.setImage(super.toolbarProperties.getString("PLATFORM")));
    }


    @Override
    public void placeYourObject () {
            ButtonOverlay bo = new ButtonOverlay();
            OverlayController oc = (OverlayController) this.getParent().getParent();
            oc.addOverlay(bo.init());
    }

   
    
    
}
