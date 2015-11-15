package gameengine;

public class Life {
	
	private double health;
	private int lives;
	
	public double getHealth(){
		return health;
	}
	
	public void setHealth(double value){
		health = value;
	}
	
	public int getLife(){
		return lives;
	}
	
	public void setLife(int value){
		lives = value;
	}
	
	public void removeHealth(double damage){
		health -= damage;
	}
	
	public void addHealth(double heal){
		health += heal;
	}
	
	public void removeLife(int value){
		lives-=value;
	}
	
	public void addLife(int value){
		lives+=value;
	}
	
	public void removeLife(){
		lives--;
	}
	
	public void addLife(){
		lives++;
	}

}
