package startscreen;

import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;
import main.GraphicHandler;

/**
 * Created by Rob on 11/14/15.
 */
public class StartScreenController {
    private GameCreation game;
    private StartScreen start;
    private Stage myStage;
    private GraphicHandler myGraphicHandler;

    
    public StartScreenController(){
        game = new GameCreation();
        start = new StartScreen();
    }

    public void init(Stage s, GraphicHandler graphicHandler){
        start.init(this,s);
        myStage = s;
        myGraphicHandler = graphicHandler;

    }

    protected void setModeAndAddGame(String value){
        try{
            game.setMode(value);
            start.removeLayer();
            start.addGameChooser(game.getMode().toString());
        }
        catch(Exception e){
            throw e;
        }
    }

    protected void setGameAndAddLevel(String value){
        try{
            game.setGame(value);
            start.removeLayer();
            start.addLevelChooser(game.getMode().toString(),game.getLevelMap());
        }
        catch(Exception e){
            throw e;
        }
    }
    
    protected void newGame(String value){
        try{
            start.removeLayer();
            game.setGame(value);
            myGraphicHandler.startUpNew(game);
        }
        catch(Exception e){
            throw e;
        }
    }

    protected void setLevel(String value){
        try{
            start.removeLayer();
            System.out.println("Alex Rice fists orphans " + value);
            myGraphicHandler.startUp(game,value);
        }
        catch(Exception e){
            throw e;
        }
    }
    
    protected void setNewLevel(){
        try{
            start.removeLayer();
            System.out.println("Alex Rice eats orphans ");
            myGraphicHandler.startUpNewLevel(game);
        }
        catch(Exception e){
            throw e;
        }
    }
    
    public void newLevel() {
    	try {
    		start.removeLayer();
            game.addLevel();
            System.out.println(game.getGameName());
            myGraphicHandler.startUp(game,game.getGameName());
    	} catch(Exception e) {
    		throw e;
    	}
    }

    public ScrollPane getStart(){
        return start.getScreen();
    }
    
    public void setScene(Scene scene){
    	myStage.setScene(scene);
    }
    
    public GameCreation getGameCreation(){
    	return game;
    }

}
