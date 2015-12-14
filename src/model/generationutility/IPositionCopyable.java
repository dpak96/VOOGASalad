package model.generationutility;

public interface IPositionCopyable {

	/**
	 * Takes in x and y, returns a copy of the given object but set the given X and Y
	 * @param x
	 * @param y
	 * @return
	 */
	public IPositionCopyable copyAtLocation(double x, double y);
	
}
