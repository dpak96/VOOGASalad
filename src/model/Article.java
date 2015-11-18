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
	private double myXVelocity;
	private double myYVelocity;
	private double myOrientation;
	private BitMap myBitMap;
	private double myWidth;
	private double myHeight;
	private List<Event> myEvents;
	private Life myLife;
	private Position myPosition;
	
	
	public Article(String image, double x, double y, boolean direction){
		myImageFile = image;
		myPosition = new Position(x, y, direction);
		myXBuffer = 40; //CHANGE IF NECESSARY
		myYBuffer = 40; //CHANGE IF NECESSARY
		myEvents = new ArrayList<Event>();
	}


	
	public Article(String file) {
		myImageFile = file;
		
		myBitMap = new BitMap(file, myPosition.getX(), myPosition.getY());
		
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
	
	public void addEvent(Event event){
		myEvents.add(event);
	}
	
	public void addAllEvents(List<Event> events){
		for(Event ev: events){
			myEvents.add(ev);
		}
	}
		
	public List<Event> getEvents(){
		return myEvents;
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
	public BitMap getBitMap() {
		return myBitMap;
	}
	
	
}
