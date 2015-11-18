package model;

import gameengine.CollisionInformation;

public class ConditionCollisionFromAbove extends Condition{
	private CollisionInformation myCollisionInformation;
	private final String ABOVE = "above";
	public ConditionCollisionFromAbove(String name, CollisionInformation collisionInformation) {
		// TODO Auto-generated constructor stub
		super(name);
		myCollisionInformation = collisionInformation;
	}
	
	@Override
	public boolean isMet() {		
		return myCollisionInformation.getCollideDirection().equals(ABOVE);		
	}
}
