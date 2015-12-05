package level.manager;

import model.Model;
import model.XMLutility.*;
import model.controller.ModelController;
import startscreen.GameCreation;
import startscreen.StartScreenController;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class LevelManager {
	private String myGame;
	private List<String> levels;
	private int currentLevel;
	private xmlUtility xmlUtil;
//	private GraphicHandler myGraphic;
//	private UICore myUI;
	private ModelController myModelCtr;
	
	public LevelManager(ModelController modelCtr) {
		levels = new ArrayList<String>();
		xmlUtil = new xmlUtility();
//		myGraphic = graphic;
//		myUI = uiCore;
		myModelCtr = modelCtr;
		updateLevels();
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
	
	public void setLevel(GameCreation game) {
		if (game.getLevel().equals("Add New Level")) {
			currentLevel = levels.size();
			addLevel("Level " + currentLevel);
			System.out.println("Level " + currentLevel);
		} else
			currentLevel = Integer.valueOf(game.getLevel());
		System.out.println(currentLevel);
		System.out.println(levels.size());

		Model model = xmlUtil.load(new File(game.getGameName()+levels.get(currentLevel)+".xml"));
		myModelCtr.setModel(model);
	}
	
	public void addLevel(String levelName) {
		levels.add(levelName);
	}
	
	public void removeLevel(int levelOrder) {
		levels.remove(levelOrder);
	}
	
	public void nextLevel() {
		if (currentLevel != 0) {
			Model model = xmlUtil.load(new File(myGame+levels.get(currentLevel+1)+".xml"));
			myModelCtr.setModel(model);
		}
	}
	
	public void previousLevel() {
		if (currentLevel != (levels.size()-1)) {
			Model model = xmlUtil.load(new File(myGame+levels.get(currentLevel-1)+".xml"));
			myModelCtr.setModel(model);
		}
	}
	
	public void updateLevels() {
		File[] files = new File("/"+myGame).listFiles();
		//If this pathname does not denote a directory, then listFiles() returns null. 
		try {
			for (File file : files) {
				levels.add(file.getName());
			}
		} catch (NullPointerException e) {
			
		}
	}
	
}
