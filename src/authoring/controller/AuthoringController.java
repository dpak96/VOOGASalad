package authoring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import authoring.backend.Editor;
import authoring.ui.AuthoringUI;
import authoring.ui.draganddrop.DraggableElement;
import authoring.ui.draganddrop.HighlightedArticle;
import authoring.ui.toolbar.PlatformButton;
import authoring.ui.toolbar.ToolbarButton;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Article;
import model.Condition;
import model.Event;
import model.Executable;
import model.controller.ModelController;


public class AuthoringController implements IAuthoringController {
  private Editor editor;
  private AuthoringUI ui;
  private ModelController modelController;
  private Executable currentExecutable;
  private Condition currentCondition;
  private Event currentEvent;

  public boolean isHighlighted() {
    return highlighted;
  }

  public void setHighlighted(boolean highlighted) {
    this.highlighted = highlighted;
  }

  private boolean highlighted = false;

  public AuthoringController(ModelController mc) {
    ui = new AuthoringUI(this);
    modelController = mc;
    editor = new Editor(mc);
  }

  public void removeArticle(Article n){
    modelController.removeArticle(n);
  }

  public Editor getEditor() {
    return editor;
  }

  public void setEditor(Editor editor) {
    this.editor = editor;
  }

  public AuthoringUI getUi() {
    return ui;
  }

  public void setUi(AuthoringUI ui) {
    this.ui = ui;
  }

  public void createAndPlaceArticle(double x, double y, DraggableElement event) {
    if(!highlighted){
      editor.getArticleEditor().createNewArticleAndPlace(event.getName(), event.getImageName(), x, y,
              true);
    }
    else {
      editor.getArticleEditor().createNewArticleAndPlace(event.getName(), event.getImageName(), x, y,
              true);

      Pane p = (Pane)event.getParent();
      p.getChildren().remove(event);
      highlighted = false;
    }


  }

  public Article getArticleFromCoordinates(double x, double y) {
    try {
      editor.getArticleEditor().setArticle(modelController.getArticleFromCoordinates(x, y));
      return editor.getArticleEditor().getArticle();
    } catch (Exception e) {
      return null;
    }
  }

  public void createAndPlaceArticle(double x, double y, ToolbarButton event) {
    editor.getArticleEditor().createNewArticleAndPlace(event.getName(), event.getImageName(), x, y,
                                                       true);
    //System.out.println("this might've happened");
    //System.out.println(event.getName());
    if(event.getName().equals("ENEMY")){
      Map<String, Object> tempMap= new HashMap<String, Object>();
      tempMap.put("myName", "penis");
      tempMap.put("myActor", editor.getArticleEditor().getArticle());
      tempMap.put("myDisplacement", .5);
      this.makeExecutable("model.ExecutableMoveHorizontal", tempMap);
      List<Executable> listExecutable = new ArrayList<Executable>();
      listExecutable.add(currentExecutable);
      List<Condition> listCondition = new ArrayList<Condition>();
      this.makeEvent("event", listCondition, listExecutable);
      List<Event> listEvent = new ArrayList<Event>();
      listEvent.add(currentEvent);
      editor.getArticleEditor().getArticle().addEvent(currentEvent);
      this.mapKey("A", listEvent);
    }

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

}
