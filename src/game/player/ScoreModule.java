package game.player;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ScoreModule extends VBox {
	
	private Text myHeader;
	private HBox myScore;
	private Double myOffset;
	
	public ScoreModule(){
		super();
		myHeader = new Text("Score: ");
		myScore = new HBox();
		myScore.setSpacing(2);
		this.getChildren().addAll(myHeader,myScore);
	}
	
	public void initScore(Double offset){
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
	
	public void update(double score){
		//scoreCheck(score);
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
	
	public void scoreCheck(double score){
		Double score2 = Math.log10(score);
		int digits = score2.intValue();
		if(digits>3){
			for(int k = digits; k<myScore.getChildren().size(); k++){
				myScore.getChildren().remove(k);
			}
			double multiplier = (4.0/(double)digits);
			for(int i=0;i<myScore.getChildren().size();i++){
				VBox temp = (VBox) myScore.getChildren().get(i);
				temp.setPadding(new Insets(multiplier*7.0, multiplier*7.0, multiplier*7.0, multiplier*7.0));
				Text digit = (Text) temp.getChildren().get(0);
				digit.setFont(Font.font(myOffset/(multiplier*8.0)));
			}
			for(int j = digits-1; j<digits; j++){
				VBox temp = new VBox();
				temp.setPadding(new Insets(multiplier*7.0, multiplier*7.0, multiplier*7.0, multiplier*7.0));
				temp.setStyle("-fx-background-color: white;" + "-fx-border-color: black;" + "-fx-border-width: 2px;" + "-fx-border-radius: 10px;" + "-fx-background-radius: 10px;");
				Text digit = new Text("0");
				digit.setFont(Font.font(myOffset/(multiplier*8.0)));
				temp.getChildren().add(digit);
				myScore.getChildren().add(temp);
			}
		}
	}
}
