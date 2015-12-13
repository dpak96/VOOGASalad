package authoring.ui.toolbar;

import authoring.controller.AuthoringController;
import authoring.ui.AuthoringUI;
import authoring.ui.smalloverlay.OverlayController;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class PlatformButton extends ToolbarButton {
  private final String NAME;

  public PlatformButton(AuthoringController myController, String imageName) {
    super(myController);
    NAME=imageName;
    super.setGraphic(super.setImage(NAME));
    super.setName(NAME);
    super.setImageName(NAME);
  }


  @Override
  public void placeYourObject () {
    ButtonOverlay bo = new PlatformOverlay(myController);
    OverlayController oc = (OverlayController) this.getParent().getParent();
    oc.addOverlay(bo.init());
    bo.init2();
  }
}

