package authoring.controller

import authoring.backend.Editor
import authoring.backend.EditorManager;
import authoring.ui.AuthoringUI;
import authoring.ui.draganddrop.DraggableElement
import authoring.ui.draganddrop.HighlightedArticle
import javafx.scene.layout.Pane
import model.Event;
import model.article.Article;
import model.controller.ModelController;
import resourcemanager.ResourceManager

import java.lang.reflect.Constructor


public class AuthoringController {
	private EditorManager editor;
	private AuthoringUI ui;

	private boolean highlighted = false;
	private Article currentArticle;
	private ModelController modelController;

	private Map<String, Object> controllerMap;
	private PresetArticleFactory presetArticleFactory;

	public AuthoringController(ModelController mc) {
		ui = new AuthoringUI(this);
		modelController = mc;
		editor = new EditorManager(mc);
		presetArticleFactory = new PresetArticleFactory(mc, this);
	}


	public void register(ModelController mc){
		ResourceBundle rb = (ResourceBundle) ResourceManager.getResourceManager().getResource("PropertiesManager", "Reflection");
		controllerMap = new HashMap<String, Editor>();
		for(String x: rb.keySet()){
			controllerMap.put(x, getNewInstance(rb.getString(x)));
		}
	}

	private getNewInstance(String cName){
		Class<?> cl = Class.forName(cName);
		Constructor<?> ctor = cl.getConstructor(AuthoringController.class);
		Object[] o = new Object[1];
		if(cName != "OtherController"){
			o[0] = this;
		}
		else{
			o[0] = modelController;
		}
		Object object = ctor.newInstance(o);
		return object;
	}

	public AuthoringUI getUi() {
		return ui;
	}

	public void setUi(AuthoringUI ui) {
		this.ui = ui;
	}


	public EditorManager getEditor() {
		return editor;
	}



	public ModelController getModelController(){
		return modelController;
	}

	public void callEvent(String controller,String method,e){
		controllers.get(controller)."$method"(e, this);
	}

	public getTester(){
		return getUi().getTester();
	}


	public presetArticle(String function, Article article) {
		presetArticleFactory."$function"(article);
	}

	public List<Article> getArticles(){
		return modelController.getArticles()
	}
    
        public addEventToModel(Event eventToAdd,String eventType, Map<String,String> eventParameters){
            this.modelController.addEvent(eventToAdd);
            if(eventType.equals("Active"))
                this.modelController.addActiveEvent(eventToAdd);
                
            if(eventType.equals("Collision"))
            this.modelController.addCollision(eventParameters.get("direction"),eventParameters.get("nameOne"),eventParameters.get("nameTwo"), eventToAdd);
            
            if(eventType.equals("Button"))
                this.modelController.remapButton(eventParameters.get("button"), eventToAdd);
                            
         
        }
        public List<String> getCollisionTypes(){
            
            return modelController.getAllCollisionTypes();
        }

	public getCurrentArticle() {
		return currentArticle;
	}

	public void setCurrentArticle(Article currArticle) {
		currentArticle = currArticle;
	}

	public void setHighlighted(boolean highlighted) {
		this.highlighted = highlighted;
	}

	public boolean getHighlighted(){
		return highlighted;
	}





}