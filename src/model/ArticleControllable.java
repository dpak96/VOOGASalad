package model;

public class ArticleControllable extends Article{
	
	public void moveRight(double defaultAccel){
		myXVelocity += defaultAccel;
	}
	
	public void moveLeft(double defaultAccel){
		myXVelocity -= defaultAccel;
	}
	
	public void moveUp(double defaultAccel){
		myYVelocity -= defaultAccel;
	}
	
	public void moveDown(double defaultAccel){
		myYVelocity += defaultAccel;
	}
	
}
