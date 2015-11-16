package authoring.controller;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import model.Article;
import model.Game;
import model.Player;


public class AuthoringController {
  private GameEditor gameEditor;
  private ArticleEditor articleEditor;
  private PlayerEditor playerEditor;
  private Point2D cursor;
  
  public AuthoringController(){
    setGameEditor(new GameEditor());
    setArticleEditor(new ArticleEditor());
    setPlayerEditor(new PlayerEditor());
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

  public Point2D getCursor() {
    return cursor;
  }

  public void setCursor(Point2D cursor) {
    this.cursor = cursor;
  }
  

}