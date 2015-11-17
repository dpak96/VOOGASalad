package model;

public class Position {
	
	protected double myXVelocity = 0;
	protected double myYVelocity = 0;

	private double myX;
	private double myY;
	
	private double myOrientation = 0;
	private boolean myDirection = true; //True = facing right; False = facing left


	public Position(double x, double y, boolean direction){
		myX = x;
		myY = y;
		
	}

	public double getXVelocity() {
		return myXVelocity;
	}
	public void setXVelocity(double myXVelocity) {
		this.myXVelocity = myXVelocity;
	}
	public double getYVelocity() {
		return myYVelocity;
	}
	public void setYVelocity(double myYVelocity) {
		this.myYVelocity = myYVelocity;
	}
	public double getX() {
		return myX;
	}
	public void setX(double myX) {
		this.myX = myX;
	}
	public double getY() {
		return myY;
	}
	public void setY(double myY) {
		this.myY = myY;
	}
	public double getOrientation() {
		return myOrientation;
	}
	public void setOrientation(double myOrientation) {
		this.myOrientation = myOrientation;
	}
	public boolean isDirection() {
		return myDirection;
	}
	public void setDirection(boolean myDirection) {
		this.myDirection = myDirection;
	}
}
