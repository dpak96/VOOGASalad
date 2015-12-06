package model.processes;

import java.util.Map;

import model.article.Article;

public class ConditionBelowPositionOnScreen extends Condition{

	protected Article myViewpoint;
	protected double myFraction;
	
	public ConditionBelowPositionOnScreen(Map<String, Object> parameters){
		super(parameters);
	}

	@Override
	public boolean isMet() {
		double yMid = myFirst.getY() + myFirst.getHeight()/2;
	
		return yMid > myViewpoint.getY() + myViewpoint.getHeight()*myFraction;
		
	}

}
