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
import model.controller.ModelController;
import model.processes.Condition;
import model.processes.Executable;


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
      article =
          editor.getArticleEditor().createNewArticleAndPlace(event.getName(), event.getImageName(),
                                                             x,
                                                             y,
                                                             true);
    } else {
      highlighted = false;
      article =
          editor.getArticleEditor().createNewArticleAndPlace(event.getName(), event.getImageName(),
                                                             x,
                                                             y,
                                                             true);
      Pane p = (Pane) event.getParent();
      p.getChildren().remove(event);
    }

    if (event.getImageName().equals("Goomba")) {
      this.goombaMovementDemo(article);
    }
    if(event.getImageName().equals("Platform")){
    	this.platformMovementDemo(article);
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
    tempMap.put("myAcceleration", .2);
    Executable ex = this.makeExecutable("ExecutableAccelerateVertical", tempMap);

    List<Executable> listExecutable = new ArrayList<Executable>();
    listExecutable.add(ex);
    List<Condition> listCondition = new ArrayList<Condition>();
    Event ev = this.makeEvent("event", listCondition, listExecutable);
    List<Event> listEvent = new ArrayList<Event>();
    listEvent.add(ev);
    modelController.addActiveEvent(ev);

    this.mapKey("A", listEvent);
    
	article.setYVelocity(0);
	article.setCollisionType("A");
	
	
  }
  
  public void platformMovementDemo(Article article){
		modelController.addNewCollisionType("A");
		modelController.addNewCollisionType("B");
	  article.setCollisionType("B");
		
		Map<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.put("myActor", article);
	    Executable ex = this.makeExecutable("ExecutableBounceVertical", tempMap);

	    List<Executable> listExecutable = new ArrayList<Executable>();
	    listExecutable.add(ex);
	    List<Condition> listCondition = new ArrayList<Condition>();
	    Event ev = this.makeEvent("event", listCondition, listExecutable);

	    modelController.addCollision("Left", "A", "B", ev);
	  
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
    } else {
      try {
        double tX = n.getX();
        double tY = n.getY();

        //authoringController.removeArticle(n);
        HighlightedArticle highlightedArticle = new HighlightedArticle(n.getImageFile(), this);
        //highlightedArticle.relocate(tX,tY);
        this.setHighlighted(true);
        ui.getDragAndDrop().getChildren().add(highlightedArticle);
        highlightedArticle.relocate(tX, tY);
      } catch (Exception execption) {
        System.out.println("hi");
      }
    }
  }

  public List<Event> getEventList(){
      return this.modelController.getAllEvents();
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
