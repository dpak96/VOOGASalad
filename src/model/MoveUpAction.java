package model;

public class MoveUpAction extends SingleDependencyRule {

	private double defaultAccel;
	
	public MoveUpAction(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void apply(Article a) {
		a.setYVelocity(a.getYVelocity() - defaultAccel*a.accelMultiplier());
	}

}
