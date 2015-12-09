package authoring.controller

import authoring.backend.EditorManager
import authoring.ui.draganddrop.DraggableElement
import authoring.ui.draganddrop.HighlightedArticle
import javafx.scene.input.DragEvent
import javafx.scene.layout.Pane
import model.article.Article
import resourcemanager.ResourceManager


class ArticleCAndGController {
    public editor;
    public authoring;

    public ArticleCAndGController(AuthoringController au, EditorManager edit){
        editor = edit;
        authoring = au;
    }

    public void createAndPlaceArticle(event) {
        Article article = null;
            article =
                    editor.getSubEditor("ArticleEditor").createNewArticleAndPlace(event.getGestureSource().getName(),event.getGestureSource().getImageName(), event.getX(), event.getY(), true);
        setPreset(event,article);
    }


    public setPreset(event, article){
        ResourceBundle rb = (ResourceBundle) ResourceManager.getResourceManager().getResource("PropertiesManager", "presetFunction");
        if (event.getGestureSource().getImageName() in rb.keySet()){
            String temp = rb.getString((String)event.getImageName());
            authoring.presetArticle(temp, article);
        }
    }
}
