package startscreen;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.xml.sax.SAXException;

import level.manager.OrdererParser;


public class GameCreation {
    public enum Mode{
        play,edit
    }
    private String myGameName;
    private Mode myMode;
    private String myLevel;
    private String myFolderPath;

    private Map<Integer,String> myLevelMap;


    public GameCreation(){
    }
    
    public Mode getMode() {
    	return myMode;
    }
    
    public String getGameName() {
    	return myGameName;
    }
    
    public String getLevel() {
    	return myLevel;
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
        setFolderPath(System.getProperty("user.home") 
				+ System.getProperty("file.separator") 
				+ "SquirtleSquadGames" + System.getProperty("file.separator")+game 
				+System.getProperty("file.separator"));
        try {
			OrdererParser order = new OrdererParser(new File(myFolderPath + game +".xml"));
					myLevelMap = order.getLevelMap();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
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
    
    public void addLevel() {
    	myLevelMap.put(myLevelMap.size()+1, "NewLevel.xml");
    }
    
    public Map<Integer,String> getLevelMap(){
    	return myLevelMap;
    }
}
