package model;

import java.util.List;

public abstract class CollisionRule extends MultiDependencyRule{

	
	public CollisionRule(String name) {
		// TODO Auto-generated constructor stub
		super(name);
	}
	
	protected void apply(List<Article> articles){
		firstReaction(articles.get(0));
		secondReaction(articles.get(1));
	}
	
	protected abstract void firstReaction(Article firstArticle);
	protected abstract void secondReaction(Article secondArticle);

}
