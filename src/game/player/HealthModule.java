package game.player;

import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import model.article.Article;

public class HealthModule extends HUDModule {
	
	private Text myHealthVal;
	private ProgressBar myHealthBar;
	private Boolean myFirstUpdate;
	private double myInitialHealth;
	
	public HealthModule(){
		super();
		myFirstUpdate = true;
		myHealthVal = new Text("Health: ");
		myHealthBar = new ProgressBar(1.0);
	}
	
	public void init(double offset){
		myHealthBar.setMaxWidth(offset/2);
		myHealthBar.setStyle("-fx-accent: red;");
		this.getChildren().addAll(myHealthVal,myHealthBar);
	}
	
	public void update(Article character){
		double health = character.getHealth();
		if(myFirstUpdate||myInitialHealth==0){
			myInitialHealth = health;
			myFirstUpdate = !myFirstUpdate;
		}
		myHealthBar.setProgress(health/myInitialHealth);
		myHealthVal.setText("Health: " + health + "/" + myInitialHealth);
	}
	
	public double getWide(){
		return myHealthBar.getMaxWidth();
	}
}
