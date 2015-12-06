package menu;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class StepButton extends AbstractControlButton {

  public StepButton() {
		super();
	}
	
	public void resize(MenuPanel menuPanel){
		ImageView image = new ImageView((Image) myImages.get("stepButton"));
		image.fitHeightProperty().bind(menuPanel.heightProperty().multiply(.65));
		image.fitWidthProperty().bind(menuPanel.heightProperty().multiply(.65));
		this.setGraphic(image);
	}
}
