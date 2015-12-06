package level.manager;

import model.Model;
import model.XMLutility.*;
import model.controller.ModelController;
import startscreen.GameCreation;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LevelManager {
	private String myGame;
	private List<String> levels;
	private int currentLevel;
	private xmlUtility xmlUtil;
	private ModelController myModelCtr;
    private Map<Integer,String> myLevelMap;
	
	public LevelManager(GameCreation game) {
		myLevelMap = game.getLevelMap();
		xmlUtil = new xmlUtility();
	}
	
	public List<String> getLevels() {
		return levels;
	}
	
	public void setGame(String game) {
		myGame = game;
	}
	
	public String[] getLevelsArr() {
		return (String[]) levels.toArray();
	}
	
	public void setLevel(int level) {
		currentLevel = level;
	}
	
	public void addLevel(String levelName) {
		levels.add(levelName);
	}
	
	public void removeLevel(int levelOrder) {
		levels.remove(levelOrder);
	}
	
	public void nextLevel() {
		if (currentLevel != 0) {
			setLevel(currentLevel+1);
			Model model = xmlUtil.load(new File(myGame+levels.get(currentLevel)+".xml"));
			myModelCtr.setModel(model);
		}
	}
	
	public void previousLevel() {
		if (currentLevel != (levels.size()-1)) {
			setLevel(currentLevel-1);
			Model model = xmlUtil.load(new File(myGame+levels.get(currentLevel-1)+".xml"));
			myModelCtr.setModel(model);
		}
	}
	
	public void updateLevels(GameCreation game) {
		myGame = game.getFolderPath();
		myLevelMap = game.getLevelMap();
//		if (game.getLevel().equals("Add New Level")) {
////			setLevel(levels.size());
////			addLevel("Level " + currentLevel);
//			System.out.println("Level " + currentLevel);
//		} else {
//			System.out.println("Ass boners " + game.getLevel());
////			setLevel(Integer.valueOf(game.getLevel()));
//			Model model = xmlUtil.load(new File(myGame+levels.get(currentLevel)+".xml"));
//			System.out.println("reading model");
//			System.out.println("floopymcfloopyasspeniswanker");
//			System.out.println(model == null);
//			myModelCtr.setModel(model);
//		}
		File[] files = new File(myGame).listFiles();
		//If this pathname does not denote a directory, then listFiles() returns null. 
		try {
			for (File file : files) {
				levels.add(file.getName());
			}
		} catch (NullPointerException e) {
			
		}
	}
	
}
