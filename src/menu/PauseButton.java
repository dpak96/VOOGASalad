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
		image.fitWidthProperty().bind(menuPanel.heightProperty());
		image.fitHeightProperty().bind(menuPanel.heightProperty());
		this.setGraphic(image);
	}

}
