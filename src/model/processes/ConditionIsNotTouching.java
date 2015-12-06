package model.processes;

import java.util.Map;

import model.article.Article;

public class ConditionIsNotTouching extends Condition{

	
	public ConditionIsNotTouching(Map<String, Object> parameters){
		super(parameters);
	}

	@Override
	public boolean isMet() {
		return !myFirst.getCollisionArticles().contains(mySecond);
	}

}
