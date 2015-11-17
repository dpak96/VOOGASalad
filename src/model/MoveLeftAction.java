package model;

public class MoveLeftAction extends Rule{


	private double defaultAccel;
	
	public MoveLeftAction(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void apply(Article a) {
		a.setXVelocity(a.getXVelocity() - defaultAccel*a.accelMultiplier());
	}

	
}
