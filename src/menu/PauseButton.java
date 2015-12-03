package menu;

import javafx.scene.image.ImageView;

public class PauseButton extends AbstractControlButton{
	
	public PauseButton(){
		super();
		this.setGraphic(new ImageView(myImages.get("pauseButton")));
	}
	
	public void resize(MenuPanel menuPanel){
		ImageView image = new ImageView(myImages.get("pauseButton"));
		image.fitWidthProperty().bind(menuPanel.heightProperty());
		image.fitHeightProperty().bind(menuPanel.heightProperty());
		this.setGraphic(image);
	}

}
