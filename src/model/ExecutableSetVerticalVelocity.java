package model;

import java.util.Map;

public class ExecutableSetVerticalVelocity extends Executable{

	double myYVelocity;
	
	public ExecutableSetVerticalVelocity(Map<String, Object> parameters){
		super(parameters);
	}

	@Override
	public void execute() {
		myActor.setYVelocity(myYVelocity);
	}

	
	
}
