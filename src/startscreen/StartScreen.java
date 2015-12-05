package startscreen;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.ResourceBundle;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import level.manager.LevelManager;

public class StartScreen {
    private StartScreenSkeleton skeleton;
    private PlayAuthorModule playEdit;
    private StartScreenController myController;
    private Stage myStage;

    public StartScreen(){
        skeleton = new StartScreenSkeleton();
        playEdit = new PlayAuthorModule();
    }

    public void init(StartScreenController controller, Stage s){
        skeleton.init();
        myController = controller;
        playEdit.init(controller);
        skeleton.addLayer(playEdit.getContainer());
        myStage = s;
    }

    public void addGameChooser(String value){
        GameChooserModule games = new GameChooserModule(getGames());
        games.init(myController, value);

        skeleton.addLayer(games.getContainer());
    }

    private String[] getGames(){
        String[] gameEx = allGames();
        return gameEx;
    }

    public void addLevelChooser(String value, Map<Integer,String> levelMap){
        LevelChooserModule levels = new LevelChooserModule(getLevels(levelMap));
        levels.init(myController, value);
        skeleton.addLayer(levels.getContainer());
    }

    private String[] getLevels(Map<Integer,String> levelMap){
        ArrayList<String> levels = new ArrayList<String>();
        ArrayList<Integer> levelNums = new ArrayList<Integer>();
        for(int i: levelMap.keySet()){
        	levelNums.add(i);
        }
        Collections.sort(levelNums);
        for(int j: levelNums){
        	levels.add(levelMap.get(j).trim().replace(".xml", ""));
        }
        return levels.toArray(new String[levels.size()]);
    }

    public Pane getScreen(){
        return skeleton.getPane();
    }

    public void removeLayer(){
        skeleton.removeLayer();
    }
    
    public String[] allGames(){
    	File allGames = new File(System.getProperty("user.home") + System.getProperty("file.separator") + "SquirtleSquadGames" + System.getProperty("file.separator"));
    	File[] all = allGames.listFiles();
    	String[] ret = new String[all.length];
    	for(int i = 0; i<all.length; i++){
    		ret[i]=(all[i].getName());
    	}
    	return ret;
    }
}
