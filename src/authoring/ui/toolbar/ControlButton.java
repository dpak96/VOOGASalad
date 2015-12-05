package authoring.ui.toolbar;

import authoring.controller.AuthoringController;
import authoring.ui.editingmenus.ArticlePropertyEditorMenu;

public class ControlButton extends ToolbarButton {
  private final String NAME = "KEYS";

  public ControlButton(AuthoringController myController) {
    super( myController);
    this.setGraphic(this.setImage(super.toolbarProperties.getString(NAME)));
    this.setName(NAME);
    this.setImageName(super.toolbarProperties.getString(NAME));
  }

  @Override
  public void placeYourObject() {

      
  }

}
