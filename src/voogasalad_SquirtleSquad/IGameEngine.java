package voogasalad_SquirtleSquad;

import java.util.List;

public interface IGameEngine {
	/**
	 * Takes the actions, if any, and performs them by checking the rules through the ModelController.
	 * If the list is empty, it runs a default update. This will edit information in the Model through
	 * the ModelController based on the rules in ModelController. 
	 * @param actions
	 */
	public void update(List<String> actions);
}
