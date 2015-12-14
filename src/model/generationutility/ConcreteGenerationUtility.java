package model.generationutility;
import java.util.*;


public abstract class ConcreteGenerationUtility extends AbstractGenerationUtility{
	

	protected IRectangular myViewpoint;
	protected double myPrevX;
	protected double myPrevY;
	
	protected double myXChange;
	protected double myYChange;
	
	//private final int boundsExtension = 200;
	

	public ConcreteGenerationUtility(IRectangular viewpoint) {
		myViewpoint = viewpoint;
		myPrevX = myViewpoint.getX();
		myPrevY = myViewpoint.getY();
	}

	@Override
	public Collection<IPositionCopyable> generate() {
		setViewCoordinateChanges();
		Collection<IPositionCopyable> generated = subGenerate();
		updatePreviousViewPositions();
		return generated;
	}
	
	private void setViewCoordinateChanges(){
		myXChange = myViewpoint.getX() - myPrevX;
		myYChange = myViewpoint.getY() - myPrevY;	
	}
	
	private void updatePreviousViewPositions(){
		myPrevX = myViewpoint.getX();
		myPrevY = myViewpoint.getY();
	}
	
	protected abstract Collection<IPositionCopyable> subGenerate();
	
/*
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
	*/

}
