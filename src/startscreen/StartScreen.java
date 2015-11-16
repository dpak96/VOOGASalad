package startscreen;

import javafx.scene.layout.Pane;

public class StartScreen {
    private StartScreenSkeleton skeleton;
    private PlayAuthorModule playEdit;
    private StartScreenController myController;

    public StartScreen(){
        skeleton = new StartScreenSkeleton();
        playEdit = new PlayAuthorModule();
    }

    public void init(StartScreenController controller){
        skeleton.init();
        myController = controller;
        playEdit.init(controller);
        skeleton.addLayer(playEdit.getContainer());
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
