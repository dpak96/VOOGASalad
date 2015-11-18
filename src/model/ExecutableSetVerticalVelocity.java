package model;

public class ExecutableSetVerticalVelocity extends Executable{

	double myYVelocity;
	
	public ExecutableSetVerticalVelocity(String name, Article actor, double yVelocity) {
		super(name, actor);
		myYVelocity = yVelocity;
	}

	@Override
	public void execute() {
		myActor.setYVelocity(myYVelocity);
	}

	
	
}
