package authoring.backend;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import model.Article;
import model.Game;
import model.Player;
import model.controller.ModelController;


public class Editor implements IEditor  {
  private GameEditor gameEditor;
  private ArticleEditor articleEditor;
  private PlayerEditor playerEditor;
  private UserInterfaceEditor userInterfaceEditor;
  private ModelController myModelController;

  public Editor(ModelController modelController) {
    setGameEditor(new GameEditor());
    setArticleEditor(new ArticleEditor(modelController));
    setPlayerEditor(new PlayerEditor());
    myModelController = modelController;
  }

  public ArticleEditor getArticleEditor() {
    return articleEditor;
  }

  public void setArticleEditor(ArticleEditor articleEditor) {
    this.articleEditor = articleEditor;
  }

  public PlayerEditor getPlayerEditor() {
    return playerEditor;
  }

  public void setPlayerEditor(PlayerEditor playerEditor) {
    this.playerEditor = playerEditor;
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

}
