package model;

import gameengine.CollisionInformation;

public class ConditionCollisionFromRight extends Condition{
	private CollisionInformation myCollisionInformation;
	private final String RIGHT = "right";
	public ConditionCollisionFromRight(String name, CollisionInformation collisionInformation) {
		// TODO Auto-generated constructor stub
		super(name);
		myCollisionInformation = collisionInformation;
	}
	
	@Override
	public boolean isMet() {		
		return myCollisionInformation.getCollideDirection().equals(RIGHT);		
	}
}
