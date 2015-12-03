package menu;

import javafx.scene.image.ImageView;

public class PlayButton extends AbstractControlButton{
	
	public PlayButton(){
		super();
	}
	
	public void resize(MenuPanel menuPanel){
		ImageView image = new ImageView(myImages.get("playButton"));
		image.fitWidthProperty().bind(menuPanel.heightProperty());
		image.fitHeightProperty().bind(menuPanel.heightProperty());
		this.setGraphic(image);
	}
}
