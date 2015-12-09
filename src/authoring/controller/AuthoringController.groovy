package authoring.controller

import authoring.backend.Editor
import authoring.backend.EditorManager;
import authoring.controller.presets.PresetArticleFactory
import authoring.ui.AuthoringUI;
import model.Event;

import authoring.ui.AuthoringUI
import authoring.ui.draganddrop.HighlightedArticle
import javafx.scene.control.Button
import model.article.Article;
import model.controller.ModelController;
import resourcemanager.ResourceManager;
import java.lang.reflect.Constructor


public class AuthoringController {

	private EditorManager myEditor;
	private AuthoringUI myUI;
	private boolean myHighlighted = false;
	private Article myCurrentArticle;
	private HighlightedArticle myCurrentButton;
	private ModelController myModelController;
	private Map<String, Object> myControllerMaps;
	private PresetArticleFactory myPresetArticleFactory;

	public AuthoringController(ModelController mc) {
		myUI = new AuthoringUI(this);
		myModelController = mc;
		myEditor = new EditorManager(mc);
		myPresetArticleFactory = new PresetArticleFactory(mc, this);
	}

	public void initalizeControllers(){
		if(myControllerMaps == null){
			register();
		}
	}
	public void register(){
		ResourceBundle rb = (ResourceBundle) ResourceManager.getResourceManager().getResource("PropertiesManager", "Controller");
		myControllerMaps = new HashMap<String, Editor>();
		for(String x: rb.keySet()){
			myControllerMaps.put(x, getNewInstance(rb.getString(x)));
		}
	}

	private getNewInstance(String cName){
		Class<?> cl = Class.forName(cName);
		Object object;
		Constructor<?> ctor = null;
		if(cName.equals("authoring.controller.OtherController") || cName.equals("authoring.controller.KeyPressController")){
			Class[] hi = new Class[2];
			hi[0] = AuthoringController.class;
			hi[1] = ModelController.class;
			ctor = cl.getConstructor(hi);
			Object[] o = new Object[2];
			o[0] = this;
			o[1] = myModelController;
			object = ctor.newInstance(o);
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
			o[0] = this;
			object = ctor.newInstance(o);
		}

		return object;
	}

	private pressDelete(){
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
		return myControllerMaps.get(controller)."$method"();
	}

	public callEvent(String controller,String method,e){
		return myControllerMaps.get(controller)."$method"(e);
	}

	public callEvent(String controller,String method, e1, e2){
		return myControllerMaps.get(controller)."$method"(e1, e2);
	}

	public callEvent(String controller,String method, e1, e2,e3){
		return myControllerMaps.get(controller)."$method"(e1,e2,e3);
	}
	public getController(String controller){
		return myControllerMaps.get(controller);
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

	public getCurrentButton() {
		return myCurrentButton;
	}

	public void setCurrentButton(b) {
		myCurrentButton = b;
	}

	public void setHighlighted(boolean highlighted) {
		this.myHighlighted = highlighted;
	}

	public boolean getHighlighted(){
		return myHighlighted;
	}

	public void flush() {
		callEvent("KeyPressController", "deleteButton");
		setCurrentArticle(null);
	}
}