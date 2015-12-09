package model.article;

public class Life {
	
	private double health;
	private double maxHealth;
	private int lives;
	
	public double getHealth(){
		return health;
	}
	
	public void setHealth(double value){
		health = value;
	}
	
	public void setMaxHealth(double value){
		maxHealth = value;
	}
	
	public int getLife(){
		return lives;
	}
	
	public void setLife(int value){
		lives = value;
	}
	
	public void removeHealth(double damage){
		health -= damage;
		if(health < 0){
			health = maxHealth;
			lives--;
		}
	}
	
	public void addHealth(double heal){
		health += heal;
		if(health > maxHealth){
			health = maxHealth;
		}
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
	
	public double getMaxHealth(){
		return maxHealth;
	}

}
