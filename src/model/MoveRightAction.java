package model;

public class MoveRightAction extends Rule{
	
	private double defaultAccel;

	
	public MoveRightAction(String name) {
		super(name);
	}
	
	@Override
	public void apply(Article a) {
		a.setXVelocity(a.getXVelocity() + defaultAccel*a.accelMultiplier());
	}

	
}
