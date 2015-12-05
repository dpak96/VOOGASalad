package menu;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class PlayButton extends AbstractControlButton{
	
	public PlayButton(){
		super();
	}
	
	public void resize(MenuPanel menuPanel){
		ImageView image = new ImageView((Image) myImages.get("playButton"));
		image.fitWidthProperty().bind(menuPanel.heightProperty());
		image.fitHeightProperty().bind(menuPanel.heightProperty());
		this.setGraphic(image);
	}
}
