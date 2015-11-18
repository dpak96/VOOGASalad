package model;

import gameengine.CollisionInformation;

public class ConditionCollisionVertical extends Condition{
	private CollisionInformation myCollisionInformation;
	private final String ABOVE = "above";
	private final String BELOW = "below";
	public ConditionCollisionVertical(String name, CollisionInformation collisionInformation) {
		// TODO Auto-generated constructor stub
		super(name);
		myCollisionInformation = collisionInformation;
	}
	
	@Override
	public boolean isMet() {		
		return myCollisionInformation.getCollideDirection().equals(ABOVE) || myCollisionInformation.getCollideDirection().equals(BELOW);		
	}
}
