package model;

public class ConditionRightOfPositionOnScreen extends Condition{
	
	private Article myViewpoint;
	private Article myCheckArticle;
	private double myFraction;
	
	public ConditionRightOfPositionOnScreen(String name, Article viewpoint, Article check, double fraction) {
		super(name);
		myViewpoint = viewpoint;
		myCheckArticle = check;
		myFraction = fraction;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isMet() {
		double xMid = myCheckArticle.getX() + myCheckArticle.getWidth()/2;
		
		return xMid > myViewpoint.getX() + myViewpoint.getWidth()*myFraction;
		
	}

}