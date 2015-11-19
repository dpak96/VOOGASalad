package authoring.ui.toolbar;

import javafx.scene.control.Button;


public class CheckpointButton extends ToolbarButton {
  private final String NAME = "CHECKPOINT";

  public CheckpointButton() {
    super();
    this.setGraphic(super.setImage(super.toolbarProperties.getString("CHECKPOINT")));
    this.setName(NAME);
    this.setImageName(super.toolbarProperties.getString(NAME));
  }

  @Override
  public void placeYourObject() {
    // TODO Auto-generated method stub

  }

}
