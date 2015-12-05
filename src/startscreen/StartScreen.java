package startscreen;

import java.util.ResourceBundle;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
        String[] gameEx = {"Game1","Game2","Game3"};
        return gameEx;
    }

    public void addLevelChooser(String value){
        LevelChooserModule levels = new LevelChooserModule(getLevels());
        levels.init(myController, value);
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
