package model;

import java.util.Map;

public class ExecutableSetHorizontalVelocity extends Executable{

	double myXVelocity;
	
	public ExecutableSetHorizontalVelocity(Map<String, Object> parameters){
		super(parameters);
	}
	
	public ExecutableSetHorizontalVelocity(String name, double xVelocity){
		super(name);
		myXVelocity = xVelocity;
	}

	@Override
	public void execute() {
		myActor.setXVelocity(myXVelocity);
	}

	
	
}
