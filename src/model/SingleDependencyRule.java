package model;

public abstract class SingleDependencyRule extends Rule {

	public SingleDependencyRule(String name) {
		super(name);
	}
	
	protected abstract void apply(Article a);
	
	public void update(){
		for(Article a: myArticles){
			apply(a);
		}
	}

}
