package model.randomgeneration;

import java.util.*;

import model.article.Article;

public class RandomGenerationUtility {

	private Article myViewpoint;
	private double myPrevX;
	private double myPrevY;

	private Article myCharacter;

	private List<Article> myArticles;

	private Map<Article, Double> myGenerationProbabilities;

	public RandomGenerationUtility(HashMap<Article, Double> probabilities, List<Article> allArticles, Article viewpoint,
			Article character) {
		myGenerationProbabilities = probabilities;
		for (Article a : myGenerationProbabilities.keySet()) {
			double prob = myGenerationProbabilities.get(a);
			double adjustedProb = 1 - Math.pow(1 - prob, 0.01);
			myGenerationProbabilities.put(a, adjustedProb);
		}
		myViewpoint = viewpoint;
		myArticles = allArticles;
		myCharacter = character;
		myPrevX = myViewpoint.getX();
		myPrevY = myViewpoint.getY();
	}

	public void update() {
		double myXChange = myViewpoint.getX() - myPrevX;
		double myYChange = myViewpoint.getY() - myPrevY;
		if (myXChange != 0)
			xGenerate(myXChange);
		else if (myYChange != 0)
			yGenerate(myYChange);

		deleteOutOfFrame();

		myPrevX = myViewpoint.getX();
		myPrevY = myViewpoint.getY();
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
