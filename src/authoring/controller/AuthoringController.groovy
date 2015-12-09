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
	private EditorManager myEditor;
	private AuthoringUI myUI;
	private boolean highlighted = false;
	private Article myCurrentArticle;
	private ModelController myModelController;

	private Map<String, Object> myControlleMaps;
	private PresetArticleFactory myPresetArticleFactory;

	public AuthoringController(ModelController mc) {
		myUI = new AuthoringUI(this);
		myModelController = mc;
		myEditor = new EditorManager(mc);
		myPresetArticleFactory = new PresetArticleFactory(mc, this);

	}

	public void initalizeControllers(){
		register();
	}


	public void register(){
		ResourceBundle rb = (ResourceBundle) ResourceManager.getResourceManager().getResource("PropertiesManager", "Controller");
		myControlleMaps = new HashMap<String, Editor>();
		for(String x: rb.keySet()){
			myControlleMaps.put(x, getNewInstance(rb.getString(x)));
		}
	}

	private getNewInstance(String cName){
		Class<?> cl = Class.forName(cName);
		Object object;
		Constructor<?> ctor = null;
		if(cName.equals("authoring.controller.OtherController")){
			Object[] o = new Object[1];
			ctor = cl.getConstructor(ModelController.class);
			Object thing1 = myModelController;
			object = ctor.newInstance(thing1);
		}
		else if(cName.equals("authoring.controller.ArticleCAndGController")){
			Class[] hi = new Class[2];
			hi[0] = AuthoringController.class;
			hi[1] = EditorManager.class;
			ctor = cl.getConstructor(hi);
			Object[] o = new Object[2];
			o[0] = this;
			o[1] = myEditor;
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

	public AuthoringUI getUi() {
		return myUI;
	}

	public void setUi(AuthoringUI ui) {
		this.myUI = ui;
	}


	public EditorManager getEditor() {
		return myEditor;
	}

	public ModelController getModelController(){
		return myModelController;
	}

	public callEvent(String controller,String method){
		return myControlleMaps.get(controller)."$method"();
	}

	public callEvent(String controller,String method,e){
		return myControlleMaps.get(controller)."$method"(e);
	}

	public callEvent(String controller,String method, e1, e2){
		return myControlleMaps.get(controller)."$method"(e1, e2);
	}

	public callEvent(String controller,String method, e1, e2,e3){
		return myControlleMaps.get(controller)."$method"(e1,e2,e3);
	}
	public getController(String controller){
		return myControlleMaps.get(controller);
	}

	public getTester(){
		return getUi().getTester();
	}


	public presetArticle(String function, Article article) {
		myPresetArticleFactory."$function"(article);
	}

	public List<Article> getArticles(){
		return myModelController.getArticles()
	}
    



	public getCurrentArticle() {
		return myCurrentArticle;
	}

	public void setCurrentArticle(Article currArticle) {
		myCurrentArticle = currArticle;
	}

	public void setHighlighted(boolean highlighted) {
		this.highlighted = highlighted;
	}

	public boolean getHighlighted(){
		return highlighted;
	}





}