package model.generationutility;

import java.util.*;

import model.article.Article;

public class ConstantGenerationUtility extends ConcreteGenerationUtility{
	
	private List<List<IPositionCopyable>> myGenerationOptions;
	private double myXDistance;
	private double myYDistance;
	
	private double accumulatedXChange;
	private double accumulatedYChange;
	
	private double myXOffset;
	private double myYOffset;

	public ConstantGenerationUtility(List<List<IPositionCopyable>> generationOptions, 
			double xDistance, double yDistance, 
			double viewpointXOffset, double viewpointYOffset,
			IRectangular viewpoint){
		super(viewpoint);
		myGenerationOptions = generationOptions;
		myXDistance = xDistance;
		myYDistance = yDistance;
		myXOffset = viewpointXOffset;
		myYOffset = viewpointYOffset;
	}
	
	@Override
	protected Collection<IPositionCopyable> subGenerate() {
		Collection<IPositionCopyable> generated = new ArrayList<IPositionCopyable>();
		accumulatedXChange += myXChange;
		accumulatedYChange += myYChange;
		
		int xGenerations = Integer.MAX_VALUE;
		int yGenerations = Integer.MAX_VALUE;
		if(myXDistance != 0) xGenerations = (int) (Math.abs(accumulatedXChange)/myXDistance);
		if(myYDistance != 0) yGenerations = (int) (Math.abs(accumulatedYChange)/myYDistance);
		int generations = Math.min(xGenerations, yGenerations);
		if(generations == Integer.MAX_VALUE) generations = 0;
		for(int i = 0; i < generations; i++){
			int randomIndex = (int) Math.floor(myGenerationOptions.size()*Math.random());

			List<IPositionCopyable> myCreation = myGenerationOptions.get(randomIndex);
			IPositionCopyable firstArticle = myCreation.get(0);
			double viewpointSpotX = myViewpoint.getX() - accumulatedXChange + i*generations;
			double viewpointSpotY = myViewpoint.getY() - accumulatedYChange + i*generations;
			IPositionCopyable newOne = firstArticle.copyAtLocation(viewpointSpotX + myXOffset, viewpointSpotY+myYOffset);
			generated.add(newOne);
			for(int j = 1; j < myCreation.size(); j++){
				double xDif = myCreation.get(j).getX()-firstArticle.getX();
				double yDif = myCreation.get(j).getY()-firstArticle.getY();
				IPositionCopyable newRelative = newOne.copyAtLocation(newOne.getX() + xDif, newOne.getY() + yDif);
				generated.add(newRelative);
			}
		}
		accumulatedXChange -= myXDistance*generations;
		accumulatedYChange -= myYDistance*generations;
		return generated;
		
	}
	/*Testing
	public static void main(String[] args){
		List<List<Article>> g = new ArrayList<List<Article>>();
		List<Article> p = new ArrayList<Article>();
		p.add(new Article("Goomba", 20, 10, true));
		p.add(new Article("Goomba", 50, 10, true));
		g.add(p);
		
		Article v = new Article("Goomba", 0, 0, true);
		List<Article> l = new ArrayList<Article>();
		ConstantGenerationUtility c = new ConstantGenerationUtility(g, 10, 0, 20, 0, l, v);
		
		while(true){
			v.setX(v.getX() + 1);
			c.update();
		}
	}
	*/

}
