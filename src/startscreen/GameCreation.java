package startscreen;

import java.io.File;

import level.manager.LevelManager;

public class GameCreation {
    public enum Mode{
        play,edit
    }
    private String myGameName;
    private Mode myMode;
    private String myLevel;
    private String myFolderPath;
    private LevelManager myLevelManager;

    public GameCreation(){
    }
    
    public Mode getMode() {
    	return myMode;
    }

    public void setMode(String mode){
        if(mode == "Play"){
            myMode = Mode.play;

        }
        else if(mode == "Edit"){
            myMode = Mode.edit;
        }
        else{
            throw new RuntimeException("WTF");
        }
    }

    public void setGame(String game){
        myGameName = game;
    }

    public void setLevel(String level){
        myLevel = level;
    }
    
    public void setFolderPath(String path){
    	myFolderPath = path;
    }
    
    public String getFolderPath(){
    	return myFolderPath;
    }
    
    public String getName(){
    	return myGameName;
    }
}
