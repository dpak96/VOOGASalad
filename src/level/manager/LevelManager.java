package level.manager;

import model.XMLutility.*;

import java.util.ArrayList;
import java.util.List;

public class LevelManager {
	private List<String> levels;
	private int currentLevel;
	private xmlUtility xmlUtil;
	
	public LevelManager() {
		levels = new ArrayList<String>();
		xm
	}
	
	public List<String> getLevels() {
		return levels;
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
