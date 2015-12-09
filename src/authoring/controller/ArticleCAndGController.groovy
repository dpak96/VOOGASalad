package authoring.controller

import authoring.backend.EditorManager
import authoring.ui.draganddrop.DraggableElement
import model.article.Article
import resourcemanager.ResourceManager


class ArticleCAndGController {

    public myEditor;
    public myAuthoring;

    public ArticleCAndGController(AuthoringController au, EditorManager edit){
        myEditor = edit;
        myAuthoring = au;
    }

    public void createAndPlaceArticle(event) {
        Article article = null;
            article =

                    myEditor.getSubEditor("ArticleEditor").createNewArticleAndPlace(event.getGestureSource().getName(),event.getGestureSource().getImageName(), event.getX(), event.getY(), true);
        setPreset(event,article);
    }


    public setPreset(event, article){
        ResourceBundle rb = (ResourceBundle) ResourceManager.getResourceManager().getResource("PropertiesManager", "presetFunction");
        if (event.getGestureSource().getImageName() in rb.keySet()){
            String temp = rb.getString((String)event.getGestureSource().getImageName());
            myAuthoring.presetArticle(temp, article);
        }
    }
}
