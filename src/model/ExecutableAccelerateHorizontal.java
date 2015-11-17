package model;

import java.util.List;

public class ExecutableAccelerateHorizontal extends Executable{

	private double myAcceleration;
	
	public ExecutableAccelerateHorizontal(String name, Article actor, double acceleration) {
		super(name, actor);
		myAcceleration = acceleration;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(){
		myActor.setXVelocity(myActor.getXVelocity() + myAcceleration);
	}
}
