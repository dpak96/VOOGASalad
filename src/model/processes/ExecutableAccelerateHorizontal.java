package model.processes;

import java.util.List;
import java.util.Map;

public class ExecutableAccelerateHorizontal extends Executable{

	private double myAcceleration;
	
	public ExecutableAccelerateHorizontal(Map<String, Object> parameters){
		super(parameters);
	}

	@Override
	public void execute(){
		myActor.setXVelocity(myActor.getXVelocity() + myAcceleration);
	}
}
