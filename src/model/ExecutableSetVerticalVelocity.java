package model;

import java.util.Map;

public class ExecutableSetVerticalVelocity extends Executable{

	double myYVelocity;
	
	public ExecutableSetVerticalVelocity(Map<String, Object> parameters){
		super(parameters);
	}

	public ExecutableSetVerticalVelocity(String name, double yVelocity){
		super(name);
		myYVelocity = yVelocity;
	}
	
	@Override
	public void execute() {
		myActor.setYVelocity(myYVelocity);
	}

	
	
}
