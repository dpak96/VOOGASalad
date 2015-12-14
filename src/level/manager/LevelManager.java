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
	private String myFolderPath, myCurrentLevelName;
	private String myGameName;
	private List<String> myLevels;
	private int myCurrentLevel;
	private xmlUtility xmlUtil;
	private ModelController myModelCtr;
	private Map<Integer, String> myLevelMap;

	public LevelManager(ModelController mc, GameCreation game) {
		myModelCtr = mc;
		myGameName = game.getGameName();
		myFolderPath = game.getFolderPath();
		xmlUtil = mc.getXMLUtility();
		try {
			myLevelMap = game.getLevelMap();
			myCurrentLevelName = game.getLevel();
			myLevels = new ArrayList<String>();
			for (Map.Entry<Integer, String> entry : myLevelMap.entrySet()) {
				myLevels.add(entry.getValue());
				if (entry.getValue().equals(myCurrentLevelName))
					myCurrentLevel = entry.getKey();
			}
		} catch (NullPointerException e) {
			myLevelMap = new HashMap<Integer, String>();
			myCurrentLevelName = "";
			myLevels = new ArrayList<String>();
			myCurrentLevel = 0;
		}
	}

	public List<String> getLevels() {
		return myLevels;
	}

	/**
	 * Game over function that loads the default game over level params: none
	 */
	public void gameOver() {

		myCurrentLevel = 1;
		myCurrentLevelName = myLevels.get(myCurrentLevel);
		Model model = myModelCtr.getXMLUtility().load(new File(myFolderPath + myGameName + "_GAMEOVER"));
		myModelCtr.updateModelWithNewModel(model);
	}

	/**
	 * nextLevel loads the next level of the game, but keeps the score/life of
	 * the previous level of the main character.
	 */
	public void nextLevel() {
		if (myCurrentLevel != 0) {
			myCurrentLevel += 1;
			myCurrentLevelName = myLevels.get(myCurrentLevel);

			Model model = xmlUtil.load(new File(myFolderPath + myCurrentLevelName));
			// model.getCharacter().setScore(myModelCtr.getCharacter().getScore());
			// model.getCharacter().setLife(myModelCtr.getCharacter().getLife());

			myModelCtr.updateModelWithNewModel(model);
		} else {
		}
	}

	public void previousLevel() {
		if (myCurrentLevel != (myLevels.size() - 1)) {
			myCurrentLevel -= 1;
			myCurrentLevelName = myLevels.get(myCurrentLevel);
			Model model = xmlUtil.load(new File(myFolderPath + myCurrentLevelName));
			model.getCharacter().setScore(myModelCtr.getCharacter().getScore());
			model.getCharacter().setLife(myModelCtr.getCharacter().getLife());
			myModelCtr.updateModelWithNewModel(model);
		}
	}

	public void changeLevelTo(int level) {
		if (level != 0) {
			myCurrentLevel = level;
			myCurrentLevelName = myLevels.get(myCurrentLevel);
			Model model = xmlUtil.load(new File(myFolderPath + myCurrentLevelName));
			model.getCharacter().setScore(myModelCtr.getCharacter().getScore());
			model.getCharacter().setLife(myModelCtr.getCharacter().getLife());
			myModelCtr.updateModelWithNewModel(model);
		}
	}

	public void resetLevel() {
		if (myCurrentLevel != 0) {
			Model model = xmlUtil.load(new File(myFolderPath + myCurrentLevelName));
			model.getCharacter().setScore(myModelCtr.getCharacter().getScore());
			model.getCharacter().setLife(myModelCtr.getCharacter().getLife());
			myModelCtr.updateModelWithNewModel(model);
		}
	}

	//
	// public void updateLevels(GameCreation game) {
	// myGame = game.getFolderPath();
	// myLevelMap = game.getLevelMap();
	//// if (game.getLevel().equals("Add New Level")) {
	////// setLevel(levels.size());
	////// addLevel("Level " + myCurrentLevel);
	//// } else {
	////// setLevel(Integer.valueOf(game.getLevel()));
	//// Model model = xmlUtil.load(new
	// File(myGame+levels.get(myCurrentLevel)+".xml"));
	//// myModelCtr.setModel(model);
	//// }
	// File[] files = new File(myGame).listFiles();
	// //If this pathname does not denote a directory, then listFiles() returns
	// null.
	// try {
	// for (File file : files) {
	// myLevels.add(file.getName());
	// }
	// } catch (NullPointerException e) {
	//
	// }
	// }

}
