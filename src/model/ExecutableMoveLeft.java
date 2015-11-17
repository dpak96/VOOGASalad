package model;

import java.util.List;

public class ExecutableMoveLeft extends Executable{

	private double myAcceleration;
	
	public ExecutableMoveLeft(Article actor, double acceleration) {
		super(actor);
		myAcceleration = acceleration;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(){
		myActor.setYVelocity(myActor.getYVelocity() - myAcceleration);
	}
}
