package model;

import java.util.*;


import gameengine.CollisionInformation;
import javafx.scene.image.Image;
import resourcemanager.ResourceManager;


/**
 * This is the hierarchy of classes of objects, or articles, for the games
 * @author danielpak
 *
 */
public class Article {
	
	private String myImageFile;
	private double myXBuffer;
	private double myYBuffer;
	private BitMap myBitMap;
	private double myWidth;
	private double myHeight;
	private List<Event> myEvents;
	private Life myLife = new Life();
	private Position myPosition;
	private Map<Article, CollisionInformation> myCollisions = new HashMap<Article, CollisionInformation>();

	public Article(String image, double x, double y, boolean direction){
		myImageFile = image;
		Image img = ResourceManager.getResourceManager().getImage(myImageFile);
		myHeight = img.getHeight();
		myWidth = img.getWidth();
		myPosition = new Position(x-myWidth/2, y-myHeight/2, direction);
		myXBuffer = 40; //CHANGE IF NECESSARY
		myYBuffer = 40; //CHANGE IF NECESSARY
		myEvents = new ArrayList<Event>();
	}
	
	public Article(String file, double x, double y) {
		myImageFile = file;
		myPosition = new Position(x, y);
		myBitMap = new BitMap(file, myPosition.getX(), myPosition.getY());
		
	}
	
	public void update(){
		myPosition.update();
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
	
	public void destroyBitMap() {
		myBitMap = null;
	}
	public void clearCollisions(){
		myCollisions.clear();
	}
	
	public void addCollision(Article article, CollisionInformation collision){
		myCollisions.put(article, collision);
	}
	
	public Set<Article> getCollisionArticles(){
		return myCollisions.keySet();
	}
	
	public CollisionInformation getCollisionInformation(Article article){
		return myCollisions.get(article);
	}
	
	public int getLife(){
		return myLife.getLife();
	}
	
	public double getHealth(){
		return myLife.getHealth();
	}
	
	
}
