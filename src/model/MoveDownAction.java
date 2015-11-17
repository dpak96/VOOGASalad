package model;

public class MoveDownAction extends SingleDependencyRule {

	private double defaultAccel;
	
	public MoveDownAction(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void apply(Article a) {
		a.setYVelocity(a.getYVelocity() + defaultAccel*a.accelMultiplier());
	}

}
