package authoring.controller

import authoring.backend.EditorManager;
import authoring.ui.AuthoringUI;
import authoring.ui.draganddrop.DraggableElement;
import javafx.scene.input.*;
import javafx.scene.layout.Pane;
import model.Event;
import model.article.Article;
import model.controller.ModelController;
import model.processes.Condition;
import model.processes.Executable;
import resourcemanager.ResourceManager


public class AuthoringController {
	private EditorManager editor;
	private AuthoringUI ui;
	private ModelController modelController;
	private boolean highlighted = false;
	private Article currentArticle;
	private double nXRight, nXLeft;
	private PresetArticleFactory presetArticleFactory;
	private DragAndDropController dragAndDropController;
	private ArticleExtenderController articleExtenderController;





	public AuthoringController(ModelController mc) {
		ui = new AuthoringUI(this);
		modelController = mc;
		editor = new EditorManager(mc);
		presetArticleFactory = new PresetArticleFactory(mc, this);
		dragAndDropController = new DragAndDropController();
		articleExtenderController = new ArticleExtenderController();

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
					editor.getSubEditor("ArticleEditor").createNewArticleAndPlace(event.getName(), event.getImageName(),
					x,
					y,
					true);
		} else {
			highlighted = false;
			article =
					editor.getSubEditor("ArticleEditor").createNewArticleAndPlace(event.getName(), event.getImageName(),
					x,
					y,
					true);
			Pane p = (Pane) event.getParent();
			p.getChildren().remove(event);
			highlighted = false;
		}
		ResourceBundle rb = (ResourceBundle) ResourceManager.getResourceManager().getResource("PropertiesManager", "presetFunction");
		if (event.getImageName() in rb.keySet()){
			String temp = rb.getString(event.getImageName());
			this.presetArticle(temp, article);			
		}
	}

	public void createAndPlaceArticle(double x, double y, String im, String name) {
		editor.getSubEditor("ArticleEditor").createNewArticleAndPlace(name, im,
				x,
				y,
				true);
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

	public List<Event> getEventList() {
		return this.modelController.getAllEvents();
	}

	public ModelController getModelController(){
		return modelController;
	}

	public void dragEvent(String method,e){
		dragAndDropController."$method"(e, this);
	}


	public void extendEvent(String method, e){
		articleExtenderController."$method"(e,this);
	}

	public void extendEvent(String method){
		articleExtenderController."$method"(this);
	}
  
    
    public Condition createCondition(String condName, Map<String,Object> params){
        this.modelController.createCondition(condName,params);
        
    }
    
    public Executable createExecutable(String execName,Map<String,Object> params){
        this.modelController.createExecutable(execName,params);
    }

	public presetArticle(String function, Article article) {
		presetArticleFactory."$function"(article);
	}

	public List<Article> getArticles(){
		return modelController.getArticles()
	}
    
        public addEventToModel(Event eventToAdd,String eventType, Map<String,String> eventParameters){
            this.modelController.getAllEvents().add(eventToAdd);
            if(eventType.equals("Ordinary"))
                this.modelController.getActiveEvents().add(eventToAdd);
                
            if(eventType.equals("Collision"))
            this.modelController.getCollisionEvents(eventParameters.get("direction"),eventParameters.get("nameOne"),eventParameters.get("nameTwo"));
            
            if(eventType.equals("Button"))
                this.modelController.getButtonEvents(eventParameters.get("button"));
            
                            
         
        }
        public List<String> getCollisionTypes(){
            
            return modelController.getAllCollisionTypes();
        }

	public Article getCurrentArticle() {
		return currentArticle
	}

	public void setCurrentArticle(Article currentArticle) {
		currentArticle = currentArticle
	}

	public void setHighlighted(boolean highlighted) {
		this.highlighted = highlighted;
	}

	public boolean getHighlighted(){
		return highlighted;
	}



}