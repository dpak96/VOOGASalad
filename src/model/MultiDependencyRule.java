package model;

import java.util.List;

public abstract class MultiDependencyRule extends Rule {

	public MultiDependencyRule(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}
	
	protected abstract void apply(List<Article> articles);
	
	public void update(){
		apply(myArticles);
	}

}
