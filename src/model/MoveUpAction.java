package model;

public class MoveUpAction extends Rule {

	private double defaultAccel;
	
	public MoveUpAction(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void apply(Article a) {
		a.setYVelocity(a.getYVelocity() - defaultAccel*a.accelMultiplier());
	}
}
