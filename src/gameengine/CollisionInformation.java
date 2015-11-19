package gameengine;

public class CollisionInformation {
	private Boolean didCollide;
	private String incidenceDirection;
	
	public CollisionInformation(String direction, Boolean real) {
		incidenceDirection = direction;
		didCollide = real;
	}
	public String getCollideDirection() {
		return incidenceDirection;
	}
	
	public Boolean isRealCollision(){
		return didCollide;
	}
	
}
