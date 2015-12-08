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
	
	public double getScore() {
		return myScore;
	}
	
	public void removeScore(double score) {
		myScore -= score;
	}
}
