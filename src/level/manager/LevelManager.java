package level.manager;

import java.util.ArrayList;
import java.util.List;

public class LevelManager {
	private List<String> levels;
	private int currentLevel;
	
	public LevelManager() {
		levels = new ArrayList<String>();
	}
	
	public void addLevel(String levelName) {
		levels.add(levelName);
	}
	
	public void removeLevel(int levelOrder) {
		levels.remove(levelOrder);
	}
	
	public void nextLevel() {
		if (currentLevel != 0) {
			
		}
	}
	
	public void previousLevel() {
		if (currentLevel != (levels.size()-1)) {
			
		}
	}
	
	public void updateLevels() {
		
	}
	
}
