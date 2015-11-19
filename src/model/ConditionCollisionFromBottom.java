package model;

import java.util.Map;

import gameengine.CollisionInformation;

public class ConditionCollisionFromBottom extends Condition{
	private CollisionInformation myCollisionInformation;
	private final String BOTTOM = "bottom";
	
	public ConditionCollisionFromBottom(Map<String, Object> parameters){
		super(parameters);
	}
	
	@Override
	public boolean isMet() {		
		return myCollisionInformation.getCollideDirection().equals(BOTTOM);		
	}
}
