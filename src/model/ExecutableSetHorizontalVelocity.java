package model;

public class ExecutableSetHorizontalVelocity extends Executable{

	double myXVelocity;
	
	public ExecutableSetHorizontalVelocity(String name, Article actor, double xVelocity) {
		super(name, actor);
		myXVelocity = xVelocity;
	}

	@Override
	public void execute() {
		myActor.setXVelocity(myXVelocity);
	}

	
	
}
