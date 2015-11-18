package model;

import gameengine.CollisionInformation;

public class ConditionCollisionFromLeft extends Condition{
	private CollisionInformation myCollisionInformation;
	private final String LEFT = "left";
	public ConditionCollisionFromLeft(String name, CollisionInformation collisionInformation) {
		// TODO Auto-generated constructor stub
		super(name);
		myCollisionInformation = collisionInformation;
	}
	
	@Override
	public boolean isMet() {		
		return myCollisionInformation.getCollideDirection().equals(LEFT);		
	}
}
