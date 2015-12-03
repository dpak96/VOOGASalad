package model;

import java.util.Map;

public class ExecutableSetVerticalVelocity extends Executable{

	double myYVelocity;
	
	public ExecutableSetVerticalVelocity(Map<String, Object> parameters){
		super(parameters);
	}

	public ExecutableSetVerticalVelocity(String name, Article actor, double yVelocity){
		super(name,actor);
		myYVelocity = yVelocity;
	}
	
	@Override
	public void execute() {
		myActor.setYVelocity(myYVelocity);
	}

	
	
}
