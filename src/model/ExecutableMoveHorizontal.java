package model;

public class ExecutableMoveHorizontal extends Executable{

	private double myDisplacement;
	
	public ExecutableMoveHorizontal(String name, Article actor, double displacement) {
		super(name, actor);
		myDisplacement = displacement;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(){
		myActor.setX(myActor.getX() + myDisplacement);
	}

}
