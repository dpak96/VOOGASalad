package model;

public class MoveLeftAction extends SingleDependencyRule{


	private double defaultAccel;
	
	public MoveLeftAction(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void apply(Article a) {
		a.moveLeft(defaultAccel);
	}
	
}
