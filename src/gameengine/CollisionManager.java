// This entire file is part of my masterpiece.
// Wuming Zhang

package gameengine;

import model.article.Article;

public class CollisionManager {
	private final double PI = 180;
	private final String[] directions = {"Right", "Bottom", "Left", "Top"};
	public CollisionInformation didCollide(Article articleOne, Article articleTwo) {		
		if (checkSimpleCollision(articleOne, articleTwo)) {
			return new CollisionInformation(getIncidenceDirection(articleOne, articleTwo), true);
		} else {
			return new CollisionInformation("", false);
		}	
	}
	
	private String getIncidenceDirection(Article a, Article b) {
		double[] directionVector = getDirectionVector(a, b);
		double degree = getDegree(directionVector);
		int index = (int) Math.floor(degree/(PI/2));
		return directions[index];
	}

	private double getDegree(double[] vector) {
		// TODO Auto-generated method stub
		int check = (vector[0] < 0) ? 1 : 0;
		double degree = check * PI + Math.toDegrees(Math.atan2(vector[1], vector[0]));
		return degree;
	}

	public double[] getDirectionVector(Article a, Article b) {
		double[] aCenter = getCenter(a);
		double[] bCenter = getCenter(b);
		double[] directionVectorX = {aCenter[0] - bCenter[0], aCenter[1] - bCenter[1]};
		return directionVectorX;
	}
	
	public double[] getCenter(Article a){
		double[] center= {a.getX() + a.getWidth(), a.getY() + a.getHeight()};
		return center;
	}
	
	//Assume A is being collided with
	private Boolean checkSimpleCollision(Article a, Article b) {
		double[] directionVector = getDirectionVector(a,b);
		double distance = Math.sqrt(Math.pow(directionVector[0],2)+Math.pow(directionVector[1],2));
		return distance <= Math.min(a.getWidth()/2, b.getWidth()/2);
	}
}
