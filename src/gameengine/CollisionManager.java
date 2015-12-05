/**
 * @author Calvin
 */

package gameengine;

import model.Article;
import model.Position;

public class CollisionManager {

	public CollisionInformation didCollide(Article articleOne, Article articleTwo) {

		if (checkSimpleCollision(articleOne, articleTwo)) {
			System.out.println("simple collision true");
			CollisionInformation temp = checkBitMapCollision(articleOne, articleTwo);
			//System.out.println(temp.isRealCollision());
			return temp;
		} else {
			return new CollisionInformation("", false);
		}
	}

	// TODO: we don't know which article comes first, we'll assume a1 is
	// colliding with a2

	// We want the incidence direction for the article that's colliding.
	private String getIncidenceDirection(Article articleOne, Position p) {
		double centerX = articleOne.getX() + articleOne.getWidth() / 2;
		double centerY = articleOne.getY() + articleOne.getHeight() / 2;
		double residualX = p.getX() - centerX;
		double residualY = p.getY() - centerY;
		if (residualX >= 0 || residualY >= 0) {
			if (residualX > residualY) {
				return "Right";
			} else if (residualX < residualY) {
				return "Bottom";
			} else {
				return "Bottom"; // Edge case (exactly on diag) returns bottom
			}
		} else {
			if (residualX > residualY) {
				return "Top";
			} else if (residualX < residualY) {
				return "Left";
			} else {
				return "Top"; // Edge case (exactly on diag) returns top
			}
		}

	}

	private CollisionInformation checkBitMapCollision(Article a, Article b) {
		
		for (Position[] p : a.getBitMap().getByteArray()) {
			for (Position q : p) {
				Position temp = checkPixelCollision(q, b.getBitMap().getByteArray());
				if (temp.isValidPosition()) {
					System.out.println("found an intersection");
					return new CollisionInformation(getIncidenceDirection(a, temp), true);
				}

			}
		}
		return new CollisionInformation("", false);
	}

	private Position checkPixelCollision(Position a, Position[][] b) {
		for (Position[] p : b) {
			for (Position q : p) {
				if (q.isValidPosition() && a.isValidPosition() && a.getX() != -1 && q.getX() != -1) {
					//System.out.println("is valid position");
					System.out.println("Comparing:" + a.getX() + " " + a.getY() + " with " + q.getX() + " " + q.getY());
					//a.getX() == q.getX() && a.getY() == q.getY()
				
					if (a.getX() == q.getX() && a.getY() == q.getY()) {
						System.out.println("found");
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
