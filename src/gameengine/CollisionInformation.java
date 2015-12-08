package gameengine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CollisionInformation {
	private Boolean didCollide;
	private String incidenceDirection;
	private final List<String> MATRIX_NAMES = new ArrayList<String>(Arrays.asList("Left","Top","Right","Bottom"));
	
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

	public CollisionInformation makeReverseDirectionObject(){
		return new CollisionInformation(MATRIX_NAMES.get((MATRIX_NAMES.indexOf(incidenceDirection)+2)%4), didCollide);
	}
	
}
