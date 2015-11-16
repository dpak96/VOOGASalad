package model;

public class MoveRightAction extends SingleDependencyRule{
	
	private double defaultAccel;

	
	public MoveRightAction(String name) {
		super(name);
	}

	@Override
	protected void apply(Article a) {
		a.moveRight(defaultAccel);
	}
	

	
}
