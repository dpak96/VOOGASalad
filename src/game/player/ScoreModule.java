// This entire file is part of my masterpiece.
// Alex Rice
package game.player;

import java.util.ArrayList;
import java.util.List;

import action.controller.ActionController;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.article.Article;

public class ScoreModule extends AbstractVHUDModule {
	
	private Text myHeader;
	private HBox myScore;
	private Double myOffset;
	private String myText;
	
	
	public ScoreModule(){
		super();
		myText = myRB.getString("SCORE");
		myHeader = new Text(myText);
		myScore = new HBox();
		myScore.setSpacing(2);
		this.getChildren().addAll(myHeader,myScore);
	}
	
	@Override
	public void init(double offset){
		ArrayList<VBox> ret = new ArrayList<VBox>();
		myOffset = offset;
		for(int i = 0; i<4; i++){
			VBox temp = new VBox();
			Text digit = new Text("0");
			digit.setFont(Font.font(myOffset/8.0));
			temp.setPadding(new Insets(7.0,7.0,7.0,7.0));
			temp.setStyle("-fx-background-color: white;" + "-fx-border-color: black;" + "-fx-border-width: 2px;" + "-fx-border-radius: 10px;" + "-fx-background-radius: 10px;");
			temp.getChildren().add(digit);
			ret.add(temp);
		}
		myScore.getChildren().addAll(ret);
	}
	
	@Override
	public void update(List<Article> arg, Article character, ActionController ac){
		scoreCheck(character.getScore());
		double score = character.getScore();
		Double score2 = score;
		int score3 = score2.intValue();
		for(int i = myScore.getChildren().size()-1; i>=0; i--){
			int added = score3%10;
			score3 = score3/10;
			VBox digitCont = (VBox) myScore.getChildren().get(i);
			Text digit = (Text) digitCont.getChildren().get(0);
			digit.setText(new Integer(added).toString());
		}
	}
	
	private void scoreCheck(double score){
		Double score2 = Math.log10(score);
		int digits = score2.intValue();
		for(int i = myScore.getChildren().size()-1; i>=4; i--){
			myScore.getChildren().remove(i);
		}
		for(int i = 3; i<digits; i++){
			VBox temp = new VBox();
			Text digit = new Text("0");
			digit.setFont(Font.font(myOffset/8.0));
			temp.setPadding(new Insets(7.0,7.0,7.0,7.0));
			temp.setStyle("-fx-background-color: white;" + "-fx-border-color: black;" + "-fx-border-width: 2px;" + "-fx-border-radius: 10px;" + "-fx-background-radius: 10px;");
			temp.getChildren().add(digit);
			myScore.getChildren().add(temp);
		}
	}
}
