package model;

import java.util.Map;

import gameengine.CollisionInformation;

public class ConditionCollisionFromAbove extends Condition{
	private CollisionInformation myCollisionInformation;
	private final String ABOVE = "above";
	
	public ConditionCollisionFromAbove(Map<String, Object> parameters){
		super(parameters);
	}
	
	@Override
	public boolean isMet() {		
		return myCollisionInformation.getCollideDirection().equals(ABOVE);		
	}
}
