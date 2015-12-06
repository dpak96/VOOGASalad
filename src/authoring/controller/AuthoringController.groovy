package authoring.controller

import imageextender.ImageExtender
import authoring.backend.EditorManager;
import authoring.ui.AuthoringUI;
import authoring.ui.draganddrop.DraggableElement;
import authoring.ui.draganddrop.HighlightedArticle;
import authoring.ui.editingmenus.ArticlePropertyEditorMenu
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
	private Article high;
	private double nXRight, nXLeft;
	private PresetArticleFactory presetArticleFactory;
	private DragAndDropController dragAndDropController;

	public void setHighlighted(boolean highlighted) {
		this.highlighted = highlighted;
	}

	public AuthoringController(ModelController mc) {
		ui = new AuthoringUI(this);
		modelController = mc;
		editor = new EditorManager(mc);
		presetArticleFactory = new PresetArticleFactory(mc, this);
		dragAndDropController = new DragAndDropController();
	}

	public void init() {
		ui.getDragAndDrop().getScene().setOnKeyReleased({ event->  addTile(event)});
	}

	public void addTile(KeyEvent event) {
		if (event.getCode() == KeyCode.B && event.isControlDown()) {

			if (nXRight == 0) {
				nXRight = high.getX() + (high.getWidth() / 2);
			}
			try {
				high.setWidth(high.getWidth()*2);
			}
			catch (Exception e){

			}
		}
		if (event.getCode() == KeyCode.V && event.isControlDown()) {

			if (nXLeft == 0) {
				nXLeft = high.getX() - (high.getWidth() / 2)+modelController.getViewpoint().getX();
			}
			try {
				nXLeft -= high.getWidth();
				high.setWidth(high.getWidth()*2);
				high.setX(nXLeft);

			} catch (Exception e) {
			}
		}
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

	public presetArticle(String function, Article article) {
		presetArticleFactory."$function"(article);
	}

	public List<Article> getArticles(){
		return modelController.getArticles()
	}
}