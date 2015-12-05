package model.processes;
import java.lang.*;
import java.lang.reflect.*;
import java.util.*;

import model.article.Article;

public class ConditionAbovePositionOnScreen extends Condition{
	
	private Article myViewpoint;
	private Article myCheckArticle;
	private double myFraction;
	
	public ConditionAbovePositionOnScreen(Map<String, Object> parameters){
		super(parameters);
	}

	@Override
	public boolean isMet() {
		double yMid = myCheckArticle.getY() + myCheckArticle.getHeight()/2;
	
		return yMid < myViewpoint.getY() + myViewpoint.getHeight()*myFraction;
		
	}

}