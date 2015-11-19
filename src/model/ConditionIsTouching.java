package model;

public class ConditionIsTouching extends Condition{

	Article myFirst;
	Article mySecond;
	
	public ConditionIsTouching(String name, Article first, Article second) {
		super(name);
		myFirst = first;
		mySecond = second;
	}

	@Override
	public boolean isMet() {
		return myFirst.getCollisionArticles().contains(mySecond);
	}

}
