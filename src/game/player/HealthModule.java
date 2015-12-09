package game.player;

import action.controller.ActionController;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import model.article.Article;

public class HealthModule extends HUDModule {
	
	private Text myHealthVal;
	private ProgressBar myHealthBar;

	
	public HealthModule(){
		super();
		myHealthVal = new Text("Health: ");
		myHealthBar = new ProgressBar(1.0);
	}
	
	public void init(double offset){
		myHealthBar.setMaxWidth(offset/2);
		myHealthBar.setStyle("-fx-accent: red;");
		this.getChildren().addAll(myHealthVal,myHealthBar);
	}
	
	public void update(Article character, ActionController ac){
		double health = character.getHealth();
		myHealthBar.setProgress(health/character.getMaxHealth());
		myHealthVal.setText("Health: " + health + "/" + character.getMaxHealth());
	}
	
	public double getWide(){
		return myHealthBar.getMaxWidth();
	}
}
