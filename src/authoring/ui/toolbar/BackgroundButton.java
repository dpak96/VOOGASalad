package authoring.ui.toolbar;

import authoring.controller.AuthoringController;
import authoring.ui.editingmenus.BackgroundMenu;

public class BackgroundButton extends ToolbarButton {
  private final String NAME = "BACKGROUND";

  public BackgroundButton(AuthoringController myController) {
    super (myController);
    this.setGraphic(super.setImage(super.toolbarProperties.getString(NAME)));
    this.setName(NAME);
    this.setImageName(super.toolbarProperties.getString(NAME));
  }

  @Override
  public void placeYourObject() {
      BackgroundMenu backgroundPopup=new BackgroundMenu(NAME, myController);

      
  }

}
