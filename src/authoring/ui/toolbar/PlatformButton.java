package authoring.ui.toolbar;

import authoring.controller.AuthoringController;
import authoring.ui.AuthoringUI;
import authoring.ui.editingmenus.ArticlePropertyEditorMenu;
import authoring.ui.smalloverlay.OverlayController;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class PlatformButton extends ToolbarButton {
  private final String NAME = "PLATFORM";

  public PlatformButton(AuthoringController myController) {
    super(myController);
    this.setGraphic(super.setImage(toolbarProperties.getString(NAME)));
    this.setName(NAME);
    this.setImageName(super.toolbarProperties.getString(NAME));
  }


  @Override
  public void placeYourObject () {
    //EnemyProperties propTest=new EnemyProperties();
    //propTest.showMenu("Enemy Property Editor");
    ButtonOverlay bo = new ButtonOverlay(myController);
    OverlayController oc = (OverlayController) this.getParent().getParent();
    oc.addOverlay(bo.init());
    bo.init2();
  }
}

