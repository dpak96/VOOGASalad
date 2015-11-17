package model;

import java.util.*;

/**
 * This is the hierarchy of classes of objects, or articles, for the games
 * @author danielpak
 *
 */
public class Article {
	
	private String myImageFile;
	private double myXBuffer;
	private double myYBuffer;
	private double myWidth;
	private double myHeight;
	private List<Rule> myRules;
	private Life myLife;
	private Position myPosition;
	
	
	public Article(String image, double x, double y, boolean direction){
		myImageFile = image;
		myPosition = new Position(x, y, direction);
		myXBuffer = 40; //CHANGE IF NECESSARY
		myYBuffer = 40; //CHANGE IF NECESSARY
		myRules = new ArrayList<Rule>();
	}


	
	public double getX(){
		return myPosition.getX();
	}
	public double getY(){
		return myPosition.getY();
	}
	public void setX(double value){
		myPosition.setX(value);
	}
	public void setY(double value){
		myPosition.setY(value);
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
		return myPosition.getXVelocity();
	}
	public void setXVelocity(double value){
		myPosition.setXVelocity(value);
	}
	public double getYVelocity(){
		return myPosition.getYVelocity();
	}
	public void setYVelocity(double value){
		myPosition.setYVelocity(value);
	}
	
	public double getOrientation(){
		return myPosition.getOrientation();
	}
	public void setOrientation(double value){
		myPosition.setOrientation(value);
	}
	
	public boolean getDirection(){
		return myPosition.isDirection();
	}
	
	public void addRule(Rule rule){
		myRules.add(rule);
	}
	
	public void addAllRules(List<Rule> rules){
		for(Rule r: rules){
			myRules.add(r);
		}
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

	public void removeHealth(double myDamage) {
		myLife.removeHealth(myDamage);
	}
	
	public void removeLife(){
		myLife.removeLife();
	}
	
	public void gainHealth(double myHealthGain){
		myLife.addHealth(myHealthGain);
	}
	
	public void gainLife(){
		myLife.addLife();
	}
	
}
