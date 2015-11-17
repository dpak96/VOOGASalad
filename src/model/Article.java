package model;

import java.util.*;

/**
 * This is the hierarchy of classes of objects, or articles, for the games
 * @author danielpak
 *
 */
public class Article {
	
	private double myX;
	private double myY;
	private String myImageFile;
	private double myXBuffer;
	private double myYBuffer;
	protected double myXVelocity;
	protected double myYVelocity;
	private double myOrientation;
	private boolean myDirection; //True = facing right; False = facing left
	private double myWidth;
	private double myHeight;
	private List<Rule> myRules;
	
	public Article(String image, double x, double y, boolean direction){
		myImageFile = image;
		myX = x;
		myY = y;
		myDirection = direction;
		myXBuffer = 40; //CHANGE IF NECESSARY
		myYBuffer = 40; //CHANGE IF NECESSARY
		myRules = new ArrayList<Rule>();
	}

	
	public double accelMultiplier(){
		return 1;
	}
	
	public double getX(){
		return myX;
	}
	public double getY(){
		return myY;
	}
	public void setX(double value){
		myX = value;
	}
	public void setY(double value){
		myY = value;
	}
	
	public String getImageFile(){
		return myImageFile;
	}
	public void setImageFile(String fileName){
		myImageFile = fileName;
	}

	public double getXBuffer(){
		return myXBuffer;
	}
	public void setXBuffer(double value){
		myXBuffer = value;
	}
	public double getYBuffer(){
		return myYBuffer;
	}
	public void setYBuffer(double value){
		myYBuffer = value;
	}
	
	public double getXVelocity(){
		return myXVelocity;
	}
	public void setXVelocity(double value){
		myXVelocity = value;
	}
	public double getYVelocity(){
		return myYVelocity;
	}
	public void setYVelocity(double value){
		myYVelocity = value;
	}
	
	public double getOrientation(){
		return myOrientation;
	}
	public void setOrientation(double value){
		myOrientation = value;
	}

	public boolean getDirection(){
		return myDirection;
	}
		
	public List<Rule> getRules(){
		return myRules;
	}
	
	public double getWidth(){
		return myWidth;
	}
	
	public double getHeight(){
		return myHeight;
	}
	
}
