package model.processes;

import java.util.Map;

import gameengine.CollisionInformation;

public class ConditionCollisionFromAbove extends Condition{
	private CollisionInformation myCollisionInformation;
	private final String ABOVE = "above";
	
	public ConditionCollisionFromAbove(Map<String, Object> parameters){
		super(parameters);
	}
	
	public ConditionCollisionFromAbove(String name, CollisionInformation wu){
		super(name);
		myCollisionInformation = wu;
	}
	
	@Override
	public boolean isMet() {		
		return myCollisionInformation.getCollideDirection().equals(ABOVE);		
	}
}
