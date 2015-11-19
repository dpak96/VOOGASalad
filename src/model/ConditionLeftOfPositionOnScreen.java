package model;

import java.util.Map;

public class ConditionLeftOfPositionOnScreen extends Condition{
	
	private Article myViewpoint;
	private Article myCheckArticle;
	private double myFraction;
	
	public ConditionLeftOfPositionOnScreen(Map<String, Object> parameters){
		super(parameters);
	}

	@Override
	public boolean isMet() {
		double xMid = myCheckArticle.getX() + myCheckArticle.getWidth()/2;
		
		return xMid < myViewpoint.getX() + myViewpoint.getWidth()*myFraction;
		
	}

}
