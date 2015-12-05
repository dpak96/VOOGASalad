package model.processes;

import java.util.Map;

import gameengine.CollisionInformation;

public class ConditionCollisionFromLeft extends Condition{
	private CollisionInformation myCollisionInformation;
	private final String LEFT = "left";
	
	public ConditionCollisionFromLeft(Map<String, Object> parameters){
		super(parameters);
	}
	
	public ConditionCollisionFromLeft(String name, CollisionInformation wu){
		super(name);
		myCollisionInformation = wu;
	}
	
	@Override
	public boolean isMet() {		
		return myCollisionInformation.getCollideDirection().equals(LEFT);		
	}
}
