package model.processes;

import java.util.Map;

import model.article.Article;

public class ConditionLeftOfPositionOnScreen extends Condition{
	
	protected Article myViewpoint;
	protected double myFraction;
	
	public ConditionLeftOfPositionOnScreen(Map<String, Object> parameters){
		super(parameters);
	}

	@Override
	public boolean isMet() {
		double xMid = myFirst.getX() + myFirst.getWidth()/2;
		
		return xMid < myViewpoint.getX() + myViewpoint.getWidth()*myFraction;
		
	}

}
