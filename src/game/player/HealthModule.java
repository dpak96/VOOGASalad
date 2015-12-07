package game.player;

import javafx.scene.control.ProgressBar;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class HealthModule extends VBox {
	
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
	
	public void update(double health){
		if(myFirstUpdate){
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
