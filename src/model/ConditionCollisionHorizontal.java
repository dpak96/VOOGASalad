package model;

import gameengine.CollisionInformation;

public class ConditionCollisionHorizontal extends Condition{
	private CollisionInformation myCollisionInformation;
	private final String LEFT = "left";
	private final String RIGHT = "right";
	public ConditionCollisionHorizontal(String name, CollisionInformation collisionInformation) {
		// TODO Auto-generated constructor stub
		super(name);
		myCollisionInformation = collisionInformation;
	}
	
	@Override
	public boolean isMet() {		
		return myCollisionInformation.getCollideDirection().equals(LEFT) || myCollisionInformation.getCollideDirection().equals(RIGHT);		
	}
}
