package authoring.ui.toolbar;

import authoring.controller.AuthoringController;
import authoring.ui.smalloverlay.OverlayController;
import javafx.scene.control.Button;


public class CheckpointButton extends ToolbarButton {
  private final String NAME = "CHECKPOINT";

  public CheckpointButton(AuthoringController myController) {
    super(myController);
    this.setGraphic(super.setImage(super.toolbarProperties.getString("CHECKPOINT")));
    this.setName(NAME);
    this.setImageName(super.toolbarProperties.getString(NAME));
  }

  @Override
  public void placeYourObject() {

      ButtonOverlay bo = new PortalOverlay(myController);
      OverlayController oc = (OverlayController) this.getParent().getParent();
      oc.addOverlay(bo.init());
      bo.init2();
      
  }

}
