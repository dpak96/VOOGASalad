/**
 * @author Calvin
 */

package gameengine;
import model.Article;
import model.Position;

public class CollisionManager {

	
	public Boolean didCollide(Article articleOne, Article articleTwo) {
		
		if (checkSimpleCollision(articleOne, articleTwo)) {
			return checkBitMapCollision(articleOne, articleTwo);
		} else {
			return false;
		}
	}
	
	private Boolean checkBitMapCollision(Article a, Article b) {
		for(Position[] p: a.getBitMap().getByteArray()) {
			for(Position q: p) {
				if(checkPixelCollision(q, b.getBitMap().getByteArray())) {
					return true;
				}
				
			}
		}
		return false;
	}
	
	private Boolean checkPixelCollision(Position a, Position[][] b) {
		for(Position[] p: b) {
			for(Position q: p) {
				if(a.getX() == q.getX() && a.getY() == q.getY()) {
					return true;
				} 
			}
		}
		return false;
		
	}
	
	private Boolean checkSimpleCollision(Article a, Article b) {
		if(a.getX()+a.getWidth() >= b.getX() && a.getY()+a.getHeight() >= b.getY()) {
			return true;
		} else if(a.getX() <= b.getX()+b.getWidth() && a.getY() <= b.getY()+b.getHeight()) {
			return true;
		} else {
			return false;
		}
	}
}
