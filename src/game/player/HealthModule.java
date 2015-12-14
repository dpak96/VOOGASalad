// This entire file is part of my masterpiece.
// Alex Rice
package game.player;

import java.util.List;

import action.controller.ActionController;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import model.article.Article;

public class HealthModule extends AbstractVHUDModule {
	
	private Text myHealthVal;
	private ProgressBar myHealthBar;
	private String myText;
	
	public HealthModule(){
		super();
		myText = myRB.getString("HEALTH");
		myHealthVal = new Text(myText);
		myHealthBar = new ProgressBar(1.0);
	}
	
	public void init(double offset){
		myHealthBar.setMaxWidth(offset/2);
		myHealthBar.setStyle("-fx-accent: red;");
		this.getChildren().addAll(myHealthVal,myHealthBar);
	}
	
	public void update(List<Article> arg, Article character, ActionController ac){
		double health = character.getHealth();
		myHealthBar.setProgress(health/character.getMaxHealth());
		myHealthVal.setText(myText + health + "/" + character.getMaxHealth());
	}
	
	public double getWide(){
		return myHealthBar.getMaxWidth();
	}
}
