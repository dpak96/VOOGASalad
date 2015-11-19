package model;
import java.lang.*;
import java.lang.reflect.*;
import java.util.*;

public class ConditionAbovePositionOnScreen extends Condition{
	
	private Article myViewpoint = new Article();
	private Article myCheckArticle = new Article();
	private double myFraction = 0;
	
	public ConditionAbovePositionOnScreen(){
		super();
	}
	
	public ConditionAbovePositionOnScreen(String name, Article viewpoint, Article check, double fraction) {
		super(name);
		myViewpoint = viewpoint;
		myCheckArticle = check;
		myFraction = fraction;
	}

	@Override
	public boolean isMet() {
		double yMid = myCheckArticle.getY() + myCheckArticle.getHeight()/2;
	
		return yMid < myViewpoint.getY() + myViewpoint.getHeight()*myFraction;
		
	}

}
