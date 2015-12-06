package generationutility;

import java.util.List;

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
	protected void typeUpdate() {
		accumulatedXChange += myXChange;
		accumulatedYChange += myYChange;
		
		int xGenerations = Integer.MAX_VALUE;
		int yGenerations = Integer.MAX_VALUE;
		if(myXDistance != 0) xGenerations = (int) (Math.abs(accumulatedXChange)/myXDistance);
		if(myYDistance != 0) yGenerations = (int) (Math.abs(accumulatedYChange)/myYDistance);
		int generations = Math.min(xGenerations, yGenerations);
		for(int i = 0; i < generations; i++){
			int randomIndex = (int) Math.floor(myGenerationOptions.size()*Math.random());

			List<Article> myCreation = myGenerationOptions.get(randomIndex);
			Article firstArticle = myCreation.get(0);
			double viewpointSpotX = myViewpoint.getX() - accumulatedXChange + i*generations;
			double viewpointSpotY = myViewpoint.getY() - accumulatedYChange + i*generations;
			Article newOne = new Article(firstArticle.getImageFile(), viewpointSpotX, viewpointSpotY);
			myArticles.add(newOne);
			for(int j = 1; j < myCreation.size(); j++){
				double xDif = myCreation.get(j).getX()-firstArticle.getX();
				double yDif = myCreation.get(j).getY()-firstArticle.getY();
				Article newRelative = new Article(myCreation.get(j).getImageFile(), 
						viewpointSpotX + xDif, viewpointSpotY + yDif);
				myArticles.add(newRelative);
			}
		}
	}

}
