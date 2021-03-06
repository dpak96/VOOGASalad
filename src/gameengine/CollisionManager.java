/**
 * @author Calvin
 */

package gameengine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import model.article.Article;
import model.article.Position;

public class CollisionManager {

	public CollisionInformation didCollide(Article articleOne, Article articleTwo) {
		
		if (checkSimpleCollision(articleOne, articleTwo)) {
			return new CollisionInformation(getIncidenceDirection(articleOne, articleTwo), true);

		} else {
			return new CollisionInformation("", false);
		}
	}

	// TODO: we don't know which article comes first, we'll assume a1 is
	// colliding with a2

	// We want the incidence direction for the article that's colliding.
//	private String getIncidenceDirection(Article articleOne, Position p) {
//		double centerX = articleOne.getX() + articleOne.getWidth() / 2;
//		double centerY = articleOne.getY() + articleOne.getHeight() / 2;
//		double residualX = p.getX() - centerX;
//		double residualY = p.getY() - centerY;
//		if (residualX >= 0 || residualY >= 0) {
//			if (residualX > residualY) {
//				return "Right";
//			} else if (residualX < residualY) {
//				return "Bottom";
//			} else {
//				return "Bottom"; // Edge case (exactly on diag) returns bottom
//			}
//		} else {
//			if (residualX > residualY) {
//				return "Top";
//			} else if (residualX < residualY) {
//				return "Left";
//			} else {
//				return "Top"; // Edge case (exactly on diag) returns top
//			}
//		}
//
//	}
	
	//NEED TO FIX LOGIC FROM LEFT
	private String getIncidenceDirection(Article a, Article b) {
		
		double pL = a.getX();             //left
		double pR = pL + a.getWidth();   //right
		double pT = a.getY();             //bottom
		double pB = pT + a.getHeight();
		double tL = b.getX();               //left
		double tR = tL + b.getWidth();
		double tT = b.getY();
		double tB = tT + b.getHeight();
			String[] directions = {"Left", "Right", "Bottom", "Top"};
		    Double inf = Double.MAX_VALUE;
		    List<Double> intersect_diffs = new ArrayList<Double>(Arrays.asList(inf, inf, inf, inf));
		    if(pR > tL && pL < tL)         
		    	// Player on left
		    	intersect_diffs.remove(0);
		        intersect_diffs.add(0, Math.abs(pR - tL));
		    if(pL < tR && pR > tR)             // Player on Right
		    	intersect_diffs.remove(1);
		        intersect_diffs.add(1, Math.abs(tR - pL));
		    if(pT > tB && pB < tB)             // Player on Bottom
		        intersect_diffs.remove(2);
		    	intersect_diffs.add(2, Math.abs(pT - tB));
		    if(pB < tT && pT > tT)             // Player on Top
		    	intersect_diffs.remove(3);
		    	intersect_diffs.add(3, Math.abs(tT - pB));
		    Collections.min(intersect_diffs);
		    // return the closest intersection
		    return directions[intersect_diffs.indexOf(Collections.min(intersect_diffs))];
	}

	private CollisionInformation checkBitMapCollision(Article b, Article a) {
		CollisionFinder finder = new CollisionFinder(a.getBitMap().getByteArray());
		while (finder.hasNext()) {
			Position p = finder.next();
			if (p.getX() != -1 && p.getY() != -1) {
				CollisionFinder secondArticle = new CollisionFinder(b.getBitMap().getByteArray());
				while (secondArticle.hasNext()) {
					Position q = secondArticle.next();
					if (q.isValidPosition()) {
						if (p.getX() == q.getX() && p.getY() == q.getY()) {
							return new CollisionInformation("Left", true);
						}
					}
				}
//				for (Position[] q: b.getBitMap().getByteArray()) {
//					for (Position r: q) {
//						if (r.getX() != -1 && r.getY() != -1) {
//							
//							if (p.getX() == r.getX() && p.getY() == r.getY()) {
////							if (Math.floor(p.getX()) == Math.floor( r.getX()) && Math.floor(p.getY()) == Math.floor(r.getY())) {
//								return new CollisionInformation(getIncidenceDirection(a, r), true);
//							} 
//						}
//					}
//				}
			} else {
			}
		}
		
		return new CollisionInformation("", false);
//		for (Position[] p : a.getBitMap().getByteArray()) {
//			for (Position q : p) {
//				Position temp = checkPixelCollision(q, b.getBitMap().getByteArray());
//				if (temp.isValidPosition()) {
//					return new CollisionInformation(getIncidenceDirection(a, temp), true);
//				}
//
//			}
//		}
//		return new CollisionInformation("", false);
	}

	private Position checkPixelCollision(Position a, Position[][] b) {
		for (Position[] p : b) {
			for (Position q : p) {
				if (q.isValidPosition() && a.isValidPosition() && a.getX() != -1 && q.getX() != -1) {

					//a.getX() == q.getX() && a.getY() == q.getY()
				
					if (a.getX() == q.getX() && a.getY() == q.getY()) {
						return new Position(a.getX(), a.getY());
					}
				}
			}
		}
		return new Position();

	}
	
	//Assume A is being collided with
	private Boolean checkSimpleCollision(Article a, Article b) {

		//A or B intersect on the X plane
		if((a.getX() >= b.getX() && a.getX() <= b.getX()+b.getWidth()) || (a.getX()+a.getWidth() >= b.getX() && a.getX()+a.getWidth() <= b.getX()+b.getWidth())) {
			if ((a.getY() >= b.getY() && a.getY()<= b.getY()+b.getHeight()) || (a.getY()+a.getHeight() >= b.getY() && a.getY()+a.getHeight() <= b.getY()+b.getHeight())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

}
