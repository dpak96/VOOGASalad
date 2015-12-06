package authoring.backend;

import java.util.HashMap;
import java.util.Map;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import model.Game;
import model.article.Article;
import model.article.Player;
import model.controller.ModelController;


public class EditorManager extends Editor {
  private GameEditor gameEditor;
  private ArticleEditor articleEditor;
  private UserInterfaceEditor userInterfaceEditor;
  private LevelEditor levelEditor;
  private Map<String, Editor> editorMap;


  public EditorManager(ModelController modelController) {
    super(modelController);
    this.register(modelController);
    setGameEditor(new GameEditor(modelController));
    setArticleEditor(new ArticleEditor(modelController));
    setLevelEditor(new LevelEditor(modelController));
  }
  
  public void register(ModelController mc){
    editorMap = new HashMap<String, Editor>();
    editorMap.put("GameEditor", new GameEditor(mc));
    editorMap.put("ArticleEditor", new ArticleEditor(mc));
    editorMap.put("UserInterfaceEditor", new UserInterfaceEditor(mc));
    editorMap.put("LevelEditor", new LevelEditor(mc));
  }

  public ArticleEditor getArticleEditor() {
    return articleEditor;
  }

  public void setArticleEditor(ArticleEditor articleEditor) {
    this.articleEditor = articleEditor;
  }

  public GameEditor getGameEditor() {
    return gameEditor;
  }

  public void setGameEditor(GameEditor gameEditor) {
    this.gameEditor = gameEditor;
  }

  public UserInterfaceEditor getUserInterfaceEditor() {
    return userInterfaceEditor;
  }

  public void setUserInterfaceEditor(UserInterfaceEditor userInterfaceEditor) {
    this.userInterfaceEditor = userInterfaceEditor;
  }

  public LevelEditor getLevelEditor() {
    return levelEditor;
  }

  public void setLevelEditor(LevelEditor levelEditor) {
    this.levelEditor = levelEditor;
  }

}
