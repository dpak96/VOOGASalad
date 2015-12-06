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
import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
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
	private PresetArticleFactory presetArticleFactory

	public void setHighlighted(boolean highlighted) {
		this.highlighted = highlighted;
	}

	public AuthoringController(ModelController mc) {
		ui = new AuthoringUI(this);
		modelController = mc;
		editor = new EditorManager(mc);
		presetArticleFactory = new PresetArticleFactory(mc, this);
	}

	public void init() {
		//ui.getDragAndDrop().getScene().setOnKeyReleased(event -> addTile(event));
	}

	public void addTile(KeyEvent event) {
		if (event.getCode() == KeyCode.B && event.isControlDown()) {

			if (nXRight == 0) {
				nXRight = high.getX() + (high.getWidth() / 2);
			}
			try {
				createAndPlaceArticle(nXRight, high.getY() + (high.getHeight() / 2), high.getImageFile(),
						high.getImageFile());
				nXRight += high.getWidth();
			} catch (Exception e) {
			}
		}
		if (event.getCode() == KeyCode.V && event.isControlDown()) {

			if (nXLeft == 0) {
				nXLeft = high.getX() - (high.getWidth() / 2);
			}
			try {
				createAndPlaceArticle(nXLeft, high.getY() + (high.getHeight() / 2), high.getImageFile(),
						high.getImageFile());
				nXLeft -= high.getWidth();
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


	public void addTemp(MouseEvent e) {
		System.out.println(e.getX());
		System.out.println(e.getY());
		Article n = getArticleFromCoordinates(e.getX(), e.getY());
		high = n;
		if (e.isPopupTrigger() || e.isControlDown()) {
			if (n != null) {
				ArticlePropertyEditorMenu popupEditingMenu =
						new ArticlePropertyEditorMenu("Object Editor", n, this);
			}
		} else {
			try {
				double tX = n.getX();
				double tY = n.getY();

				// authoringController.removeArticle(n);
				HighlightedArticle highlightedArticle = new HighlightedArticle(n.getImageFile(), this);
				// highlightedArticle.relocate(tX,tY);
				this.setHighlighted(true);
				ui.getDragAndDrop().getChildren().add(highlightedArticle);
				highlightedArticle.relocate(tX, tY);
			} catch (Exception execption) {
				System.out.println("hi");
			}
		}
	}

	public List<Event> getEventList() {
		return this.modelController.getAllEvents();
	}

	public void tester(MouseEvent e) {
		double x = e.getX();
		double y = e.getY();
		Article n = getArticleFromCoordinates(x, y);
		if (e.isPopupTrigger() || e.isControlDown()) {
			if (n != null) {
				ArticlePropertyEditorMenu popupEditingMenu =
						new ArticlePropertyEditorMenu("Object Editor", n, this);
			}
		} else {
			Button b = (Button) e.getSource();
			Pane p = (Pane) b.getParent();
			p.getChildren().remove(b);
		}
	}


	public void thingy(DragEvent event){
		/* data dropped */
		if(event.getGestureSource() instanceof HighlightedArticle){
			HighlightedArticle highlightedArticle = (HighlightedArticle) event.getGestureSource();
			double tempX = highlightedArticle.getLayoutX()+0.1;
			double tempY = highlightedArticle.getLayoutY()+0.1;
			Article n = authoringController.getArticleFromCoordinates(tempX,tempY);
			//System.out.println(n == null);
			n.setX((double)event.getX() + modelController.getViewpoint().getX());
			n.setY((double)event.getY() + modelController.getViewpoint().getY());
			Pane p = (Pane)highlightedArticle.getParent();
			p.getChildren().remove(highlightedArticle);
		}
		else {
			createAndPlaceArticle(event.getX(), event.getY(), (DraggableElement) event.getGestureSource());
		}
		Dragboard db = event.getDragboard();
		boolean success = false;
		if (db.hasImage()) {
			success = true;
		}
		event.setDropCompleted(success);
		event.consume();
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
                this.modelController.getButtonEvents(eventParamters.get("button"));
            
                            
         
        }
        
}