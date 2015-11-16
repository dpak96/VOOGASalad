package model;

import java.util.List;

/**
 * This is the hierarchy of classes of objects, or articles, for the games
 * @author danielpak
 *
 */
public class Article {
	
	private double myX;
	private double myY;
	private String myImageFile;
	private boolean active;
	private double myXBuffer;
	private double myYBuffer;
	private double myXVelocity;
	private double myYVelocity;
	private double myOrientation;
	private BitMap myBitMap;
	
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
	
	public boolean getActive(){
		return active;
	}
	
	public void setActive(boolean value){
		active = value;
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
	public BitMap getBitMap() {
		return myBitMap;
	}
	
	
}
