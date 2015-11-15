package startscreen;

import javafx.scene.layout.Pane;

/**
 * Created by Rob on 11/14/15.
 */
public class StartScreenController {
    private GameCreation game;
    private StartScreen start;


    public StartScreenController(){
        game = new GameCreation();
        start = new StartScreen();
    }

    public void init(){
        start.init(this);
    }

    protected void setModeAndAddGame(String value){
        try{
            System.out.print(value);
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
        }
        catch(Exception e){
            throw e;
        }
    }

    public Pane getStart(){
        return start.getScreen();
    }

}
