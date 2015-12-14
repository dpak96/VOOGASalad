// This entire file is part of my masterpiece.
// BRANDON HO

package model.generationutility;

import java.util.*;

import model.article.Article;

public class RandomGenerationUtility extends ConcreteGenerationUtility{

	
	private double myCheckDistance = 25;

	private Map<IPositionCopyable, Double> myGenerationProbabilities;
	
	
	//Set up the random generation utility
	/**
	 * probabilities is a map from objects that can be generated to the probability that they are generated
	 * viewpoint is supposed to represent the screen that the user sees. It controls
	 * where things are being generated through this utility.
	 * @param probabilities
	 * @param viewpoint
	 */
	public RandomGenerationUtility(Map<IPositionCopyable, Double> probabilities, IRectangular viewpoint) {
		super(viewpoint);
		myGenerationProbabilities = probabilities;
	}
	
	//Changes how often the program checks to see if an object should be generated
	//Probability is adjusted to such that the object appears at same intervals
	//eg, probability = 0.5 would have an object appear on average once every 2 units of distance regardless of checkDistance
	public void setCheckDistance(double checkDistance){
		myCheckDistance = checkDistance;
		setAdjustedProbabilities();
	}
	
	//Changes the probabilities for a new checkdistance
	private void setAdjustedProbabilities(){
		for (IPositionCopyable potentialGeneratedObject : myGenerationProbabilities.keySet()) {
			double prob = myGenerationProbabilities.get(potentialGeneratedObject);
			double adjustedProb = 1 - Math.pow(1 - prob, myCheckDistance);
			myGenerationProbabilities.put(potentialGeneratedObject, adjustedProb);
		}
	}
	
	//Generate both horizontally and vertically
	public Collection<IPositionCopyable> subGenerate() {
		Collection<IPositionCopyable> generatedObjects = new HashSet<IPositionCopyable>();
		generatedObjects.addAll(xGenerate());
		generatedObjects.addAll(yGenerate());
		return generatedObjects;
	}
	
	
	//Generates horizontally 
	private Collection<IPositionCopyable> xGenerate() {
		Collection<IPositionCopyable> xGenerated = new ArrayList<IPositionCopyable>();
		for (double i = 0.0; i < Math.abs(myXChange); i += myCheckDistance) {
			for (double j = 0.0; j < myViewpoint.getHeight(); j += myCheckDistance) {
				for (IPositionCopyable potentialGeneratedObject : myGenerationProbabilities.keySet()) {
					double newX = getNewX(i);
					double newY = myViewpoint.getY()+j;
					attemptGeneration(xGenerated, newX, newY, potentialGeneratedObject);
				}
			}
		}
		return xGenerated;
	}
	
	//Generate Vertically
	private Collection<IPositionCopyable> yGenerate() {
		Collection<IPositionCopyable> yGenerated = new ArrayList<IPositionCopyable>();
		for (int j = 0; j < Math.abs(myYChange); j += myCheckDistance) {
			for (int i = 0; i < myViewpoint.getWidth(); i += myCheckDistance) {
				for (IPositionCopyable potentialGeneratedObject : myGenerationProbabilities.keySet()) {
					double newX = myViewpoint.getX()+i;
					double newY = getNewY(j);
					attemptGeneration(yGenerated, newX, newY, potentialGeneratedObject);
				}
			}
		}
		return yGenerated;
	}

	//gets X of where a newly generated object should be
	private double getNewX(double i){
		if(myXChange > 0) return myViewpoint.getX()+myViewpoint.getWidth()-i;
		else return myViewpoint.getX() + i;
		
	}
	
	//gets Y of where a newly generated object should be
	private double getNewY(double j){
		if(myYChange > 0) return myViewpoint.getY() + myViewpoint.getHeight() - j;
		else return myViewpoint.getY() + j;
	}
	
	//Rolls a number and generates an object if it fits the probability, adds said object to list of generated objects
	private void attemptGeneration(Collection<IPositionCopyable> generated, double x, double y, IPositionCopyable copyable){
		if (Math.random() < myGenerationProbabilities.get(copyable)) {
			IPositionCopyable copy = copyable.copyAtLocation(x, y);
			generated.add(copy);
		}
	}
	

}
