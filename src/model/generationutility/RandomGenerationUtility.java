package model.generationutility;

import java.util.*;

import model.article.Article;

public class RandomGenerationUtility extends ConcreteGenerationUtility{

	
	private final double unitCheck = 25;

	private Map<Article, Double> myGenerationProbabilities;
	
	
	//Set up the random generation utility
	public RandomGenerationUtility(Map<IPositionCopyable>, Double> probabilities, Article viewpoint) {
		super(allArticles, viewpoint);
		myGenerationProbabilities = probabilities;
		for (Article a : myGenerationProbabilities.keySet()) {
			double prob = myGenerationProbabilities.get(a);
			double adjustedProb = 1 - Math.pow(1 - prob, unitCheck);
			myGenerationProbabilities.put(a, adjustedProb);
		}
	}
	
	//Switches between vertical and horizontal generation
	public void utilityGenerate() {
		if (myXChange != 0)
			xGenerate(myXChange);
		if (myYChange != 0)
			yGenerate(myYChange);
	}
	
	
	//Generates horizontally 
	private void xGenerate(double myXChange) {
		for (double i = 0.0; i < Math.abs(myXChange); i += unitCheck) {
			for (double j = 0.0; j < myViewpoint.getHeight(); j += unitCheck) {
				for (Article a : myGenerationProbabilities.keySet()) {
					if (Math.random() < myGenerationProbabilities.get(a)) {
						Article copy = new Article(a.getImageFile(), a.getX(), myViewpoint.getY() + j, true);
						copy.setCollisionType(a.getCollisionType());
						if (myXChange > 0)
							copy.setX(myViewpoint.getX() + myViewpoint.getWidth() - i);
						else
							copy.setX(myViewpoint.getX() + i);
						myArticles.add(copy);
					}
				}
			}
		}
	}

	private void yGenerate(double myYChange) {
		for (int j = 0; j < Math.abs(myYChange); j += unitCheck) {
			for (int i = 0; i < myViewpoint.getWidth(); i += unitCheck) {
				for (Article a : myGenerationProbabilities.keySet()) {
					if (Math.random() < myGenerationProbabilities.get(a)) {
						Article copy = new Article(a.getImageFile(), myViewpoint.getX() + i, a.getY(), true);
						copy.setCollisionType(a.getCollisionType());
						if (myYChange > 0)
							copy.setY(myViewpoint.getY() + myViewpoint.getHeight() - j);
						else
							copy.setY(myViewpoint.getY() + j);
						myArticles.add(copy);
					}
				}
			}
		}
	}
	

}
