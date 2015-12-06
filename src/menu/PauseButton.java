package menu;

import javafx.geometry.Insets;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PauseButton extends AbstractControlButton{
	
	public PauseButton(){
		super();
	}
	
	public void resize(MenuPanel menuPanel){
		ImageView image = new ImageView((Image) myImages.get("pauseButton"));
		image.fitHeightProperty().bind(menuPanel.heightProperty().multiply(.65));
		image.fitWidthProperty().bind(menuPanel.heightProperty().multiply(.65));
		this.setGraphic(image);
	}

}
