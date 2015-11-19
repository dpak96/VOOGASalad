package authoring.ui.toolbar;

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
    // TODO Auto-generated method stub

  }

}
