package game.player;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.article.Article;
import resourcemanager.ResourceManager;

public class LivesModule extends VBox {
	
	private FlowPane myVisualLives;
	private Text myLivesVal;
	
	public LivesModule(){
		super();
		myLivesVal = new Text("Lives: ");
		myVisualLives = new FlowPane();
		this.getChildren().addAll(myLivesVal, myVisualLives);
	}
	
	public void init(double length){
		myVisualLives.setPrefWrapLength(length*4/3);
		myVisualLives.setVgap(3);
		myVisualLives.setHgap(3);
	}
	
	public void update(int life, Article character){
		myLivesVal.setText("Lives: " + life);
		for(int i = myVisualLives.getChildren().size()-1; i>=0;i--){
			myVisualLives.getChildren().remove(i);
		}
		Image img = (Image) ResourceManager.getResourceManager().getResource("ImageManager", character.getImageFile());
		for(int i = 0; i<life; i++){
			ImageView temp = new ImageView(img);
			temp.setFitWidth(myVisualLives.getPrefWrapLength()/5);
			temp.setFitHeight(myVisualLives.getPrefWrapLength()/5);
			myVisualLives.getChildren().add(temp);
		}
	}
}
