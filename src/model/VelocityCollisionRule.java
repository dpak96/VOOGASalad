package model;

public class VelocityCollisionRule extends CollisionRule{
	private double myFirstXVelocity;
	private double myFirstYVelocity;
	private double mySecondXVelocity;
	private double mySecondYVelocity;
	public VelocityCollisionRule(String name, double firstXVelocity, double firstYVelocity, double secondXVelocity, double secondYVelocity) {
		// TODO Auto-generated constructor stub
		super(name);
		myFirstXVelocity = firstXVelocity;
		myFirstYVelocity = firstYVelocity;
		mySecondXVelocity = secondXVelocity;
		mySecondYVelocity = secondYVelocity;
	}

	protected void firstReaction(Article firstArticle){
		firstArticle.setXVelocity(myFirstXVelocity);
		firstArticle.setYVelocity(myFirstYVelocity);
	}
	
	protected void secondReaction(Article secondArticle){
		secondArticle.setXVelocity(mySecondXVelocity);
		secondArticle.setYVelocity(mySecondYVelocity);
	}
}
