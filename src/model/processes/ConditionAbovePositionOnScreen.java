package model.processes;
import java.lang.*;
import java.lang.reflect.*;
import java.util.*;

import model.article.Article;

public class ConditionAbovePositionOnScreen extends Condition{
	
	protected Article myViewpoint;
	protected double myFraction;
	
	public ConditionAbovePositionOnScreen(Map<String, Object> parameters){
		super(parameters);
	}

	@Override
	public boolean isMet() {
		double yMid = myFirst.getY() + myFirst.getHeight()/2;
	
		return yMid < myViewpoint.getY() + myViewpoint.getHeight()*myFraction;
		
	}

}
