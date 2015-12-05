package model.processes;

import java.util.Map;

import gameengine.CollisionInformation;

public class ConditionCollisionFromBottom extends Condition{
	private CollisionInformation myCollisionInformation;
	private final String BOTTOM = "bottom";
	
	public ConditionCollisionFromBottom(Map<String, Object> parameters){
		super(parameters);
	}
	
	public ConditionCollisionFromBottom(String name, CollisionInformation wu){
		super(name);
		myCollisionInformation = wu;
	}
	@Override
	public boolean isMet() {		
		return myCollisionInformation.getCollideDirection().equals(BOTTOM);		
	}
}
