package authoring.controller

import authoring.backend.Editor
import authoring.backend.EditorManager;
import authoring.ui.AuthoringUI;
import model.Event;
import model.article.Article;
import model.controller.ModelController;
import resourcemanager.ResourceManager;
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
		register();
	}


	public void register(){
		ResourceBundle rb = (ResourceBundle) ResourceManager.getResourceManager().getResource("PropertiesManager", "Controller");
		controllerMap = new HashMap<String, Editor>();
		for(String x: rb.keySet()){
			controllerMap.put(x, getNewInstance(rb.getString(x)));
		}
	}

	private getNewInstance(String cName){
		Class<?> cl = Class.forName(cName);
		Object[] o = new Object[1];
		Constructor<?> ctor = null;
		if(!cName.equals("authoring.controller.OtherController")){
			ctor = cl.getConstructor(AuthoringController.class);
			o[0] = this;
		}
		else{
			ctor = cl.getConstructor(ModelController.class);
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

	public callEvent(String controller,String method){
		return controllerMap.get(controller)."$method"();
	}

	public callEvent(String controller,String method,e){
		return controllerMap.get(controller)."$method"(e);
	}

	public callEvent(String controller,String method, e1, e2){
		return controllerMap.get(controller)."$method"(e1, e2);
	}

	public callEvent(String controller,String method, e1, e2,e3){
		return controllerMap.get(controller)."$method"(e1,e2,e3);
	}
	public getController(String controller){
		return controllerMap.get(controller);
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