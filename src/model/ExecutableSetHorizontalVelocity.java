package model;

import java.util.Map;

public class ExecutableSetHorizontalVelocity extends Executable{

	double myXVelocity;
	
	public ExecutableSetHorizontalVelocity(Map<String, Object> parameters){
		super(parameters);
	}

	@Override
	public void execute() {
		myActor.setXVelocity(myXVelocity);
	}

	
	
}
