package model.generationutility;

import java.util.*;

import model.article.Article;

public class ConstantGenerationUtility extends ConcreteGenerationUtility{
	
	private List<List<Article>> myGenerationOptions;
	private double myXDistance;
	private double myYDistance;
	
	private double accumulatedXChange;
	private double accumulatedYChange;
	
	private double myXOffset;
	private double myYOffset;

	public ConstantGenerationUtility(List<List<Article>> generationOptions, 
			double xDistance, double yDistance, 
			double viewpointXOffset, double viewpointYOffset,
			List<Article> allArticles, Article viewpoint){
		super(allArticles, viewpoint);
		myGenerationOptions = generationOptions;
		myXDistance = xDistance;
		myYDistance = yDistance;
		myXOffset = viewpointXOffset;
		myYOffset = viewpointYOffset;
	}
	
	@Override
	protected void utilityGenerate() {
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

			List<Article> myCreation = myGenerationOptions.get(randomIndex);
			Article firstArticle = myCreation.get(0);
			double viewpointSpotX = myViewpoint.getX() - accumulatedXChange + i*generations;
			double viewpointSpotY = myViewpoint.getY() - accumulatedYChange + i*generations;
			System.out.println("firstArticle " + firstArticle);
			System.out.println("firstArticle.getImageFile() " + firstArticle.getImageFile());
			System.out.println("viewpointSpotX+myXOffset " + viewpointSpotX+myXOffset);
			System.out.println("viewpointSpotY+myYOffset " + viewpointSpotY+myYOffset);
			Article newOne = new Article(firstArticle.getImageFile(), viewpointSpotX+myXOffset, viewpointSpotY+myYOffset, true);
			myArticles.add(newOne);
			for(int j = 1; j < myCreation.size(); j++){
				double xDif = myCreation.get(j).getX()-firstArticle.getX();
				double yDif = myCreation.get(j).getY()-firstArticle.getY();
				Article newRelative = new Article(myCreation.get(j).getImageFile(), 
						newOne.getX() + xDif, newOne.getY() + yDif, true);
				myArticles.add(newRelative);
			}
		}
		accumulatedXChange -= myXDistance*generations;
		accumulatedYChange -= myYDistance*generations;
		
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
