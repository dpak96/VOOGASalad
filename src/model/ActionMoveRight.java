package model;

public class ActionMoveRight extends Action{
	
	private double defaultAccel;
	
	public void execute(){
		for(ArticleControllable art : myArticles){
			art.moveRight(defaultAccel);
		}
	}
	
}
