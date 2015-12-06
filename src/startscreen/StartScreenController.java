package startscreen;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import level.manager.LevelManager;
import main.GraphicHandler;
import model.controller.ModelController;

/**
 * Created by Rob on 11/14/15.
 */
public class StartScreenController {
    private GameCreation game;
    private StartScreen start;
    private Stage myStage;
    private GraphicHandler myGraphicHandler;
    private LevelManager myLevelManager;

    
    public StartScreenController(){
        game = new GameCreation();
        start = new StartScreen();
    }
    
    public StartScreenController(LevelManager levelManager){
    	myLevelManager = levelManager;
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
            start.addGameChooser(value);
        }
        catch(Exception e){
            throw e;
        }
    }

    protected void setGameAndAddLevel(String value){
        try{
            game.setGame(value);
            start.removeLayer();
            start.addLevelChooser(value,game.getLevelMap());
            myGraphicHandler.updateLevels(game);
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
            game.setLevel(value);
            myGraphicHandler.startUp(game,value);
        }
        catch(Exception e){
            throw e;
        }
    }

    public Pane getStart(){
        return start.getScreen();
    }
    
    public void setScene(Scene scene){
    	myStage.setScene(scene);
    }
    
    public GameCreation getGameCreation(){
    	return game;
    }

}
