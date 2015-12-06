package model.processes;

import java.util.Map;

import gameengine.CollisionInformation;

public class ConditionCollisionFromRight extends Condition{
	protected CollisionInformation myCollisionInformation;
	private final String RIGHT = "right";
	
	public ConditionCollisionFromRight(Map<String, Object> parameters){
		super(parameters);
	}
	
	public ConditionCollisionFromRight(String name, CollisionInformation wu){
		super(name);
		myCollisionInformation = wu;
	}
	
	@Override
	public boolean isMet() {		
		return myCollisionInformation.getCollideDirection().equals(RIGHT);		
	}
}
