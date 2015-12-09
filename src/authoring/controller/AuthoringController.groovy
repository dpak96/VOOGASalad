package authoring.controller

import authoring.backend.Editor
import authoring.backend.EditorManager;
import authoring.ui.AuthoringUI
import javafx.scene.control.Button
import model.article.Article;
import model.controller.ModelController;
import resourcemanager.ResourceManager;
import java.lang.reflect.Constructor


public class AuthoringController {
	private EditorManager myEditor;
	private AuthoringUI myUI;
	private boolean highlighted = false;
	private Article myCurrentArticle;
	private Button myCurrentButton;
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
		register();

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