package model;

import java.util.Map;

import gameengine.CollisionInformation;

public class ConditionCollisionFromLeft extends Condition{
	private CollisionInformation myCollisionInformation;
	private final String LEFT = "left";
	
	public ConditionCollisionFromLeft(Map<String, Object> parameters){
		super(parameters);
	}
	@Override
	public boolean isMet() {		
		return myCollisionInformation.getCollideDirection().equals(LEFT);		
	}
}
