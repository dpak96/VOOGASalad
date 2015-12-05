package startscreen;

import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import level.manager.LevelManager;

public class StartScreen {
    private StartScreenSkeleton skeleton;
    private PlayAuthorModule playEdit;
    private StartScreenController myController;
    private Stage myStage;
    private LevelManager levelMng;

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
        ArrayList<String> levels = new ArrayList<String>();
        levels.add("Add New LeveL");
        levels.addAll(levelMng.getLevels());
        return levels.toArray(new String[levels.size()]);
    }

    public Pane getScreen(){
        return skeleton.getPane();
    }

    public void removeLayer(){
        skeleton.removeLayer();
    }
}
