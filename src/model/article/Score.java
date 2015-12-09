package model.article;

public class Score {
	private double myScore;
	
	public Score(double score) {
		myScore = score;
	}
	
	public Score() {
		myScore = 0;
	}
	public void gainScore(double score) {
		myScore += score;
	}
	
	public void gainScore() {
		myScore+=10;
	}
	public double getScore() {
		return myScore;
	}
	
	public void removeScore(double score) {
		if (myScore-score < 0) {
			myScore = 0;
		} else {
			myScore -= score;
		}
	}
	
	public void removeScore() {
		if (myScore-- < 0) {
			myScore = 0;
		} else {
			myScore--;
		}
	}
}
