package model;

public class ExecutableMoveVertical extends Executable{
	
	double myDisplacement;

	public ExecutableMoveVertical(String name, Article actor, double displacement) {
		super(name, actor);
		myDisplacement = displacement;
	}

	@Override
	public void execute(){
		myActor.setY(myActor.getY() + myDisplacement);
	}

}
