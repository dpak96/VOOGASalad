package model.article;

import java.util.*;


import gameengine.CollisionInformation;
import javafx.scene.image.Image;
import model.BitMap;
import resourcemanager.ResourceManager;


/**
 * This is the hierarchy of classes of objects, or articles, for the games
 * @author danielpak
 *
 */
public class Article{

	public enum Status {ACTIVE, INACTIVE, HARDINACTIVE};

	private String myImageFile;
	private double myXBuffer;
	private double myYBuffer;
	private BitMap myBitMap;
	private double myWidth;
	private double myHeight;
	private Life myLife = new Life();
	private Score myScore = new Score();
	private Position myPosition;
	private Map<Article, CollisionInformation> myCollisions = new HashMap<Article, CollisionInformation>();
	private String myCollisionType;
	private Status myStatus;

	public Article(String image, double x, double y, boolean direction){
		myImageFile = image;
		Image img = (Image) ResourceManager.getResourceManager().getResource("ImageManager", myImageFile);
		myHeight = img.getHeight();
		myWidth = img.getWidth();
		myPosition = new Position(x, y, direction);
		myXBuffer = 40; //CHANGE IF NECESSARY
		myYBuffer = 40; //CHANGE IF NECESSARY
		//myBitMap = new BitMap(image, x, y);	
		myStatus = Status.ACTIVE;
	}



	public Article(String file, double x, double y) {
		myImageFile = file;
		myPosition = new Position(x, y);
		//myBitMap = new BitMap(file, myPosition.getX(), myPosition.getY());

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
		Image img = (Image) ResourceManager.getResourceManager().getResource("ImageManager", myImageFile);
		myHeight = img.getHeight();
		myWidth = img.getWidth();
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
	
	public void setWidth(Double val){
		myWidth = val;
	}

	public void setHeight(Double val){
		myHeight = val;
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

	public void gainLife(int life) {
		myLife.addLife(life);
	}
	
	public void gainLife(){
		myLife.addLife();
	}
	
	public void removeLife(){
		myLife.removeLife();
	}
	
	public void removeLife(int life) {
		myLife.removeLife(life);
	}
	
	public void setLife(int value) {
		myLife.setLife(value);
	}
	
	public void setHealth(double value){
		myLife.setHealth(value);
	}
	
	public void gainHealth(double myHealthGain){
		myLife.addHealth(myHealthGain);
	}
	
	public void setScore(double score) {
		myScore.removeScore(myScore.getScore());
		myScore.gainScore(score);
	}
	public void gainScore(double score) {
		myScore.gainScore(myScore.getScore()+score);
	}
	
	public void gainScore() {
		myScore.gainScore();
	}
	public void removeScore(double score) {
		myScore.removeScore(score);
	}
	
	public void removeScore() {
		myScore.removeScore();
	}
	
	public double getScore() {
		return myScore.getScore();
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

	public String getCollisionType(){
		return myCollisionType;
	}

	public void setCollisionType(String collisionType){
		myCollisionType = collisionType;
	}

	public Status getStatus(){
		return myStatus;
	}
	
	public void setActive(){
		myStatus = Status.ACTIVE;
	}
	
	public void setHardInactive(){
		myStatus = Status.HARDINACTIVE;
	}
	
	public void setInactive(){
		myStatus = Status.INACTIVE;
	}

	public void setDirection(boolean direction) {
		// TODO Auto-generated method stub

	}



	public void setName(String name) {
		// TODO Auto-generated method stub

	}

}
