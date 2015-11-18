package model;

import gameengine.CollisionInformation;

public class ConditionCollisionFromBottom extends Condition{
	private CollisionInformation myCollisionInformation;
	private final String BOTTOM = "bottom";
	public ConditionCollisionFromBottom(String name, CollisionInformation collisionInformation) {
		// TODO Auto-generated constructor stub
		super(name);
		myCollisionInformation = collisionInformation;
	}
	
	@Override
	public boolean isMet() {		
		return myCollisionInformation.getCollideDirection().equals(BOTTOM);		
	}
}
