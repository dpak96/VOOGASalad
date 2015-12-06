package model.article;

public class Position {
	
	protected double myXVelocity = 0;
	protected double myYVelocity = 0;

	private double myX;
	private double myY;
	
	private double myOrientation = 0;
	private boolean myDirection = true; //True = facing right; False = facing left

	private boolean isValid;
	
	public Position() {
		isValid = false;
	}
	public Position(double x, double y){
		myX = x;
		myY = y;
		if (x == -1 && y == -1) {
			isValid = false;
			
		} else {
			isValid = true;
		}
	}
	public Position(double x, double y, boolean direction){
		myX = x;
		myY = y;
		myDirection = direction;
		isValid = true;
	}
	
	public void update(){
		myX += myXVelocity;
		myY += myYVelocity;
		if(myXVelocity > 0) myDirection = true;
		if(myXVelocity < 0) myDirection = false;
	}

	public boolean isValidPosition() {
		return isValid;
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
