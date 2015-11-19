package model;

import java.util.Map;

public class ExecutableAccelerateVertical extends Executable{
	
	private double myAcceleration;
	
	public ExecutableAccelerateVertical(Map<String, Object> parameters){
		super(parameters);
	}

	@Override
	public void execute(){
		myActor.setYVelocity(myActor.getYVelocity() + myAcceleration);
	}

}
