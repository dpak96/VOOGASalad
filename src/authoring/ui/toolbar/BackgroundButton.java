package authoring.ui.toolbar;

public class BackgroundButton extends ToolbarButton {
  private final String NAME = "BACKGROUND";

  public BackgroundButton() {
    super();
    this.setGraphic(super.setImage(super.toolbarProperties.getString(NAME)));
    this.setName(NAME);
    this.setImageName(super.toolbarProperties.getString(NAME));
  }

  @Override
  public void placeYourObject() {
    // TODO Auto-generated method stub

  }

}
