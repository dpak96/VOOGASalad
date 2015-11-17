package model;

public class ExecutableAccelerateVertical extends Executable{
	
	private double myAcceleration;
	
	public ExecutableAccelerateVertical(String name, Article actor, double acceleration) {
		super(name, actor);
		myAcceleration = acceleration;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(){
		myActor.setYVelocity(myActor.getYVelocity() + myAcceleration);
	}

}
