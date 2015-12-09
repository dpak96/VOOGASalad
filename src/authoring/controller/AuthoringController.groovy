package authoring.controller

import authoring.backend.Editor
import authoring.backend.EditorManager;
import authoring.ui.AuthoringUI
import javafx.scene.control.Button;
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
	private Button currentButton;
	private ModelController modelController;

	private Map<String, Object> controllerMap;
	private PresetArticleFactory presetArticleFactory;

	public AuthoringController(ModelController mc) {
		ui = new AuthoringUI(this);
		modelController = mc;
		editor = new EditorManager(mc);
		presetArticleFactory = new PresetArticleFactory(mc, this);

	}

	public void initalizeControllers(){
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
		Object object;
		Constructor<?> ctor = null;
		if(cName.equals("authoring.controller.OtherController")){
			Class[] hi = new Class[2];
			hi[0] = AuthoringController.class;
			hi[1] = ModelController.class;
			ctor = cl.getConstructor(hi);
			Object[] o = new Object[2];
			o[0] = this;
			o[1] = modelController;
			object = ctor.newInstance(o);
		}
		else if(cName.equals("authoring.controller.ArticleCAndGController")){
			Class[] hi = new Class[2];
			hi[0] = AuthoringController.class;
			hi[1] = EditorManager.class;
			ctor = cl.getConstructor(hi);
			Object[] o = new Object[2];
			o[0] = this;
			o[1] = editor;
			object = ctor.newInstance(o);
		}

		else{
			ctor = cl.getConstructor(AuthoringController.class);
			Object[] o = new Object[1];
			Object thing1 = this;
			object = ctor.newInstance(thing1);

		}

		return object;
	}

	private pressDelete(){

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
    



	public getCurrentArticle() {
		return currentArticle;
	}

	public void setCurrentArticle(Article currArticle) {
		currentArticle = currArticle;
	}

	public getCurrentButton() {
		return currentButton;
	}

	public void setCurrentButton(Button b) {
		currentButton = b;
	}

	public void setHighlighted(boolean highlighted) {
		this.highlighted = highlighted;
	}

	public boolean getHighlighted(){
		return highlighted;
	}





}