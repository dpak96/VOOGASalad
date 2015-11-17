package model;

import java.util.List;

public class RuleGravity extends Rule{

	private double yAcceleration;
	
	public RuleGravity(String name, double gravity) {
		super(name);
		yAcceleration = gravity;
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void update(Article art) {
		art.setYVelocity(art.getYVelocity() + yAcceleration);
	}
	
	public double getYAcceleration(){
		return yAcceleration;
	}
	
	public void setYAcceleration(double gravity){
		yAcceleration = gravity;
	}
	
}
