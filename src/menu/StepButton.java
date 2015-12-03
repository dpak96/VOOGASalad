package menu;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class StepButton extends AbstractControlButton {

  public StepButton() {
    super();
    this.setGraphic(new ImageView((Image) myImages.get("stepButton")));
  }

  public void resize(MenuPanel menuPanel) {
    ImageView image = new ImageView((Image) myImages.get("stepButton"));
    image.fitWidthProperty().bind(menuPanel.heightProperty());
    image.fitHeightProperty().bind(menuPanel.heightProperty());
    this.setGraphic(image);
  }
}
