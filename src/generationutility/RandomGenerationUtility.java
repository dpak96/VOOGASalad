package generationutility;

import java.util.*;

import model.article.Article;

public class RandomGenerationUtility extends ConcreteGenerationUtility{


	private Map<Article, Double> myGenerationProbabilities;

	public RandomGenerationUtility(Map<Article, Double> probabilities, List<Article> allArticles, Article viewpoint) {
		super(allArticles, viewpoint);
		myGenerationProbabilities = probabilities;
		for (Article a : myGenerationProbabilities.keySet()) {
			double prob = myGenerationProbabilities.get(a);
			double adjustedProb = 1 - Math.pow(1 - prob, 0.01);
			myGenerationProbabilities.put(a, adjustedProb);
		}
	}

	public void typeUpdate() {
		if (myXChange != 0)
			xGenerate(myXChange);
		else if (myYChange != 0)
			yGenerate(myYChange);
	}

	private void xGenerate(double myXChange) {
		for (int i = 0; i < Math.abs(myXChange); i += 0.01) {
			for (int j = 0; j < myViewpoint.getHeight(); j += 0.01) {
				for (Article a : myGenerationProbabilities.keySet()) {
					if (Math.random() < myGenerationProbabilities.get(a)) {
						Article copy = new Article(a.getImageFile(), a.getX(), myViewpoint.getY() + j);
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
		for (int j = 0; j < Math.abs(myYChange); j += 0.01) {
			for (int i = 0; j < myViewpoint.getWidth(); i += 0.01) {
				for (Article a : myGenerationProbabilities.keySet()) {
					if (Math.random() < myGenerationProbabilities.get(a)) {
						Article copy = new Article(a.getImageFile(), myViewpoint.getX() + i, a.getY());
						if (myYChange > 0)
							copy.setY(myViewpoint.getY() + myViewpoint.getHeight() - j);
						else
							copy.setY(myViewpoint.getY() + i);
						myArticles.add(copy);
					}
				}
			}
		}
	}


}
