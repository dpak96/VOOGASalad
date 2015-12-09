package model.generationutility;

import java.util.Iterator;
import java.util.List;

import model.article.Article;

public abstract class ConcreteGenerationUtility extends AbstractGenerationUtility{
	

	protected List<Article> myArticles;
	protected Article myViewpoint;
	protected double myPrevX;
	protected double myPrevY;
	
	protected double myXChange;
	protected double myYChange;
	
	private final int boundsExtension = 200;
	

	public ConcreteGenerationUtility(List<Article> allArticles, Article viewpoint) {
		myArticles = allArticles;
		myViewpoint = viewpoint;
		myPrevX = myViewpoint.getX();
		myPrevY = myViewpoint.getY();
	}

	@Override
	public void update() {
		myXChange = myViewpoint.getX() - myPrevX;
		myYChange = myViewpoint.getY() - myPrevY;
//		System.out.println(myXChange);
//		System.out.println(myYChange);
//		System.out.println("I want to murder everyone");
		typeUpdate();	
		deleteOutOfFrame();
		myPrevX = myViewpoint.getX();
		myPrevY = myViewpoint.getY();
	}
	
	protected abstract void typeUpdate();
	

	private void deleteOutOfFrame() {
		for (Iterator<Article> iterator = myArticles.iterator(); iterator.hasNext();) {
			Article a = iterator.next();
			if(a.getX()+a.getWidth() + boundsExtension < myViewpoint.getX() ||
					a.getX() > myViewpoint.getX() + myViewpoint.getWidth() + boundsExtension ||
					a.getY() + a.getHeight() + boundsExtension < myViewpoint.getY() ||
					a.getY() > myViewpoint.getY() + myViewpoint.getHeight() + boundsExtension){
				iterator.remove();
			}
		}
	}

}
