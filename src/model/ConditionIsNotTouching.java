package model;

import java.util.Map;

public class ConditionIsNotTouching extends Condition{

	Article myFirst;
	Article mySecond;
	
	public ConditionIsNotTouching(Map<String, Object> parameters){
		super(parameters);
	}

	@Override
	public boolean isMet() {
		return !myFirst.getCollisionArticles().contains(mySecond);
	}

}
