package model;

public class MoveResetHorizontal extends SingleDependencyRule{

	private double defaultDeccel;
	
	public MoveResetHorizontal(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void apply(Article a) {
		double xVelocity = a.getXVelocity();
		if(Math.abs(xVelocity) <= defaultDeccel) a.setXVelocity(0);
		else{
			a.setXVelocity(xVelocity - Math.signum(defaultDeccel)*defaultDeccel);
		}
	}
	
}
