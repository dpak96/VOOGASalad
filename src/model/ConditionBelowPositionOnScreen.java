package model;

public class ConditionBelowPositionOnScreen extends Condition{
	
	private Article myViewpoint;
	private Article myCheckArticle;
	private double myFraction;
	
	public ConditionBelowPositionOnScreen(String name, Article viewpoint, Article check, double fraction) {
		super(name);
		myViewpoint = viewpoint;
		myCheckArticle = check;
		myFraction = fraction;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMet() {
		double yMid = myCheckArticle.getY() + myCheckArticle.getHeight()/2;
	
		return yMid > myViewpoint.getY() + myViewpoint.getHeight()*myFraction;
		
	}

}