package generationutility;

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
		typeUpdate();	
		deleteOutOfFrame();
		myPrevX = myViewpoint.getX();
		myPrevY = myViewpoint.getY();
	}
	
	protected abstract void typeUpdate();
	

	private void deleteOutOfFrame() {
		for (Iterator<Article> iterator = myArticles.iterator(); iterator.hasNext();) {
			Article a = iterator.next();
			if(a.getX()+a.getWidth() < myViewpoint.getX() ||
					a.getX() > myViewpoint.getX() + myViewpoint.getWidth() ||
					a.getY() + a.getHeight() < myViewpoint.getY() ||
					a.getY() > myViewpoint.getY() + myViewpoint.getHeight()){
				iterator.remove();
			}
		}
	}

}
