package authoring.ui.toolbar;

import authoring.ui.editingmenus.EnemyProperties;

public class ControlButton extends ToolbarButton {
  private final String NAME = "KEYS";

  public ControlButton() {
    super();
    this.setGraphic(this.setImage(super.toolbarProperties.getString(NAME)));
    this.setName(NAME);
    this.setImageName(super.toolbarProperties.getString(NAME));
  }

  @Override
  public void placeYourObject() {

          EnemyProperties testProp=new EnemyProperties("Editor", null);
      
  }

}
