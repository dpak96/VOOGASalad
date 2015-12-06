package menu;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PauseButton extends AbstractControlButton{
	
	public PauseButton(){
		super();
		Image image = (Image) myImages.get("pauseButton");
		this.setGraphic(new ImageView(image));
	}
	
	public void resize(MenuPanel menuPanel){
		ImageView image = new ImageView((Image) myImages.get("pauseButton"));
		image.fitWidthProperty().bind(menuPanel.heightProperty().multiply(.65));
		image.fitHeightProperty().bind(menuPanel.heightProperty().multiply(.65));
		this.setGraphic(image);
	}

}
