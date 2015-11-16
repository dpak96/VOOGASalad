package authoring.controller;

import javafx.scene.Node;
import javafx.scene.image.Image;
import model.Article;
import model.Game;
import model.Player;


public class AuthoringController {
  private GameEditor gameEditor;
  private ArticleEditor articleEditor;
  private PlayerEditor playerEditor;
  
  public AuthoringController(){
    gameEditor = new GameEditor();
    articleEditor = new ArticleEditor();
    playerEditor = new PlayerEditor();
  }
  
  public void setGame(Game game){
    gameEditor.setGame(game);
  }
  
  public void setArticle(Article article){
    articleEditor.setArticle(article);
  }
  
  public void setPlayer(Player player){
    playerEditor.setPlayer(player);
  }
}
