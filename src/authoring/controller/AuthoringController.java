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
import model.Event;
import model.article.Article;
import model.conditions.Condition;
import model.controller.ModelController;
import model.executables.Executable;


public class AuthoringController implements IAuthoringController {
  private EditorManager editor;
  private AuthoringUI ui;
  private ModelController modelController;
  private Executable currentExecutable;
  private Condition currentCondition;
  private Event currentEvent;
  private boolean highlighted = false;

  public void setHighlighted(boolean highlighted) {
    this.highlighted = highlighted;
  }

  public AuthoringController(ModelController mc) {
    ui = new AuthoringUI(this);
    modelController = mc;
    editor = new EditorManager(mc);
  }

  // TODO Method for editing an article

  public void removeArticle(Article n) {
    modelController.removeArticle(n);
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

  public void createAndPlaceArticle(double x, double y, ToolbarButton event) {
    editor.getArticleEditor().createNewArticleAndPlace(event.getName(), event.getImageName(), x, y,
                                                       true);

  }

  public Map<String, Class<?>> getFactoryParameters(String s) {
    return modelController.getParameters(s);
  }

  public void makeExecutable(String s, Map<String, Object> map) {
    currentExecutable = modelController.createExecutable(s, map);
  }

  public void makeCondition(String s, Map<String, Object> map) {
    currentCondition = modelController.createCondition(s, map);
  }

  public void makeEvent(String s, List<Condition> lc, List<Executable> le) {
    currentEvent = modelController.createEvent(s, lc, le);
  }

  public void mapKey(String button, List<Event> events) {
    modelController.remapButton(button, events);
  }

  public void goombaMovementDemo(Article article) {
    Map<String, Object> tempMap = new HashMap<String, Object>();
    tempMap.put("myActor", article);
    tempMap.put("myDisplacement", .5);
    this.makeExecutable("model.ExecutableMoveHorizontal", tempMap);
    List<Executable> listExecutable = new ArrayList<Executable>();
    listExecutable.add(currentExecutable);
    List<Condition> listCondition = new ArrayList<Condition>();
    this.makeEvent("event", listCondition, listExecutable);
    List<Event> listEvent = new ArrayList<Event>();
    listEvent.add(currentEvent);
    modelController.addActiveEvent(currentEvent);
    this.mapKey("A", listEvent);
  }


  public void addTemp(MouseEvent e){
    System.out.println(e.getX());
    System.out.println(e.getY());
    Article n = getArticleFromCoordinates(e.getX(),e.getY());
    if(e.isPopupTrigger()||e.isControlDown())
    {
      if(n!=null){
        ArticlePropertyEditorMenu popupEditingMenu=new ArticlePropertyEditorMenu("Object Editor",n, this);
      }
    }
    else{
      try {
        double tX = n.getX();
        double tY = n.getY();
        //authoringController.removeArticle(n);
        HighlightedArticle highlightedArticle = new HighlightedArticle(n.getImageFile(), this);
        //highlightedArticle.relocate(tX,tY);
        this.setHighlighted(true);
        ui.getDragAndDrop().getChildren().add(highlightedArticle);
        highlightedArticle.relocate(tX,tY);
      }
      catch (Exception execption){
        System.out.println("hi");
      }
    }
  }


  public void tester(MouseEvent e){
    double x = e.getX();
    double y = e.getY();
    Article n = getArticleFromCoordinates(x,y);
    if(e.isPopupTrigger()||e.isControlDown())
    {
      if(n!=null){
        ArticlePropertyEditorMenu popupEditingMenu=new ArticlePropertyEditorMenu("Object Editor",n, this);
      }
    }
  }

}
