package startscreen;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Created by Rob on 11/14/15.
 */
public class StartScreenController {
    private GameCreation game;
    private StartScreen start;
    private Stage myStage;


    public StartScreenController(){
        game = new GameCreation();
        start = new StartScreen();
    }

    public void init(Stage s){
        start.init(this,s);
        myStage = s;
    }

    protected void setModeAndAddGame(String value){
        try{
            game.setMode(value);
            start.removeLayer();
            start.addGameChooser();
        }
        catch(Exception e){
            throw e;
        }
    }

    protected void setGameAndAddLevel(String value){
        try{
            game.setGame(value);
            start.removeLayer();
            start.addLevelChooser();
        }
        catch(Exception e){
            throw e;
        }
    }

    protected void setLevel(String value){
        try{
            start.removeLayer();
            game.setLevel(value);
            start.addLevel();
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

}
