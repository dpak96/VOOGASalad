package model;

public class ExecutableMoveHorizontal extends Executable{

	private double myDisplacement;
	
	public ExecutableMoveHorizontal(Article actor, double displacement) {
		super(actor);
		myDisplacement = displacement;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void execute(){
		myActor.setX(myActor.getX() - myDisplacement);
	}

}
