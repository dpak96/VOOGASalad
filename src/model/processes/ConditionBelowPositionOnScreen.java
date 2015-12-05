package model.processes;

import java.util.Map;

import model.article.Article;

public class ConditionBelowPositionOnScreen extends Condition{
	
	private Article myViewpoint;
	private Article myCheckArticle;
	private double myFraction;
	
	public ConditionBelowPositionOnScreen(Map<String, Object> parameters){
		super(parameters);
	}

	@Override
	public boolean isMet() {
		double yMid = myCheckArticle.getY() + myCheckArticle.getHeight()/2;
	
		return yMid > myViewpoint.getY() + myViewpoint.getHeight()*myFraction;
		
	}

}