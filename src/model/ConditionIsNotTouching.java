package model;

public class ConditionIsNotTouching extends Condition{

	Article myFirst;
	Article mySecond;
	
	public ConditionIsNotTouching(String name, Article first, Article second) {
		super(name);
		myFirst = first;
		mySecond = second;
	}

	@Override
	public boolean isMet() {
		return !myFirst.getCollisionArticles().contains(mySecond);
	}

}
