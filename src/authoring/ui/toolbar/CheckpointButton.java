package authoring.ui.toolbar;

import authoring.controller.AuthoringController;
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
    // TODO Auto-generated method stub

  }

}
