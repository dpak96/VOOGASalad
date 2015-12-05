package authoring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import authoring.backend.Editor;
import authoring.backend.EditorManager;
import authoring.ui.AuthoringUI;
import authoring.ui.draganddrop.DraggableElement;
import authoring.ui.draganddrop.HighlightedArticle;
import authoring.ui.editingmenus.ArticlePropertyEditorMenu;
import authoring.ui.toolbar.PlatformButton;
import authoring.ui.toolbar.ToolbarButton;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.Article;
import model.Condition;
import model.Event;
import model.Executable;
import model.controller.ModelController;


public class AuthoringController implements IAuthoringController {
  private EditorManager editor;
  private AuthoringUI ui;
  private ModelController modelController;
  private boolean highlighted = false;

  public void setHighlighted(boolean highlighted) {
    this.highlighted = highlighted;
  }

  public AuthoringController(ModelController mc) {
    ui = new AuthoringUI(this);
    modelController = mc;
    editor = new EditorManager(mc);
  }


  public EditorManager getEditor() {

    return editor;
  }

  public void setEditor(EditorManager editor) {
    this.editor = editor;
  }

  public AuthoringUI getUi() {
    return ui;
  }

  public void setUi(AuthoringUI ui) {
    this.ui = ui;
  }

  public void createAndPlaceArticle(double x, double y, DraggableElement event) {
    Article article = null;
    if (!highlighted) {
      article = editor.getArticleEditor().createNewArticleAndPlace(event.getName(), event.getImageName(), x,
                                                         y,
                                                         true);
    } else {
      highlighted = false;
      article = editor.getArticleEditor().createNewArticleAndPlace(event.getName(), event.getImageName(), x,
                                                         y,
                                                         true);
      Pane p = (Pane) event.getParent();
      p.getChildren().remove(event);
    }

    if (event.getImageName().equals("Goomba")) {
      this.goombaMovementDemo(article);
    }

  }

  public Article getArticleFromCoordinates(double x, double y) {
    try {
      return modelController.getArticleFromCoordinates(x, y);
    } catch (Exception e) {
      System.out.println("oops");
      return null;
    }
  }

  public Map<String, Class<?>> getFactoryParameters(String s) {
    return modelController.getParameters(s);
  }

  public Executable makeExecutable(String s, Map<String, Object> map) {
    return modelController.createExecutable(s, map);
  }

  public Condition makeCondition(String s, Map<String, Object> map) {
    return modelController.createCondition(s, map);
  }

  public Event makeEvent(String s, List<Condition> lc, List<Executable> le) {
    return modelController.createEvent(s, lc, le);
  }

  public void mapKey(String button, List<Event> events) {
    modelController.remapButton(button, events);
  }

  public void goombaMovementDemo(Article article) {
    Map<String, Object> tempMap = new HashMap<String, Object>();
    tempMap.put("myActor", article);
    tempMap.put("myDisplacement", .5);
    Executable ex = this.makeExecutable("model.ExecutableMoveHorizontal", tempMap);
    List<Executable> listExecutable = new ArrayList<Executable>();
    listExecutable.add(ex);
    List<Condition> listCondition = new ArrayList<Condition>();
    Event ev = this.makeEvent("event", listCondition, listExecutable);
    List<Event> listEvent = new ArrayList<Event>();
    listEvent.add(ev);
    article.addEvent(ev);
    this.mapKey("A", listEvent);
  }


  public void addTemp(MouseEvent e, Article n, AuthoringController authoringController){
    if(e.isPopupTrigger())
    {
      if(n!=null){
        ArticlePropertyEditorMenu popupEditingMenu=new ArticlePropertyEditorMenu("Object Editor",n, authoringController);
      }
    }
    else{
      try {
        double tX = n.getX();
        double tY = n.getY();
        authoringController.getEditor().getArticleEditor().removeArticle(n);
        HighlightedArticle highlightedArticle = new HighlightedArticle(n.getImageFile());
        //highlightedArticle.relocate(tX,tY);
        authoringController.setHighlighted(true);
        ui.getDragAndDrop().getChildren().add(highlightedArticle);
        highlightedArticle.relocate(tX,tY);
      }
      catch (Exception execption){
        System.out.println("hi");
      }
    }
  }

}
