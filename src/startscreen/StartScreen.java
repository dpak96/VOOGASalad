package startscreen;

import java.util.ResourceBundle;

import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;
import javafx.stage.Stage;
import uibasics.UICore;

public class StartScreen {
    private StartScreenSkeleton skeleton;
    private PlayAuthorModule playEdit;
    private StartScreenController myController;
    private ResourceBundle myResource = ResourceBundle.getBundle("properties/english");
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

    public void addGameChooser(){
        GameChooserModule games = new GameChooserModule(getGames());
        games.init(myController);

        skeleton.addLayer(games.getContainer());
    }

    private String[] getGames(){
        String[] gameEx = {"Game1","Game2","Game3"};
        return gameEx;
    }

    public void addLevelChooser(){
        LevelChooserModule levels = new LevelChooserModule(getLevels());
        levels.init(myController);
        skeleton.addLayer(levels.getContainer());
    }

    private String[] getLevels(){
        String[] levelEx = {"Level1","Level2","Level3"};
        return levelEx;
    }

    public Pane getScreen(){
        return skeleton.getPane();
    }

    public void removeLayer(){
        skeleton.removeLayer();
    }
}
