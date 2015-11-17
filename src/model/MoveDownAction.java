package model;

public class MoveDownAction extends Rule {

	private double defaultAccel;
	
	public MoveDownAction(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void apply(Article a) {
		a.setYVelocity(a.getYVelocity() + defaultAccel*a.accelMultiplier());
	}


}
