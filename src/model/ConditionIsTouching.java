package model;
import java.util.*;

public class ConditionIsTouching extends Condition{

	Article myFirst;
	Article mySecond;
	
	public ConditionIsTouching(Map<String, Object> parameters){
		super(parameters);
	}

	@Override
	public boolean isMet() {
		return myFirst.getCollisionArticles().contains(mySecond);
	}

}
