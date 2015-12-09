package authoring.controller

import authoring.ui.draganddrop.DraggableElement
import authoring.ui.draganddrop.HighlightedArticle
import javafx.scene.layout.Pane
import model.article.Article
import resourcemanager.ResourceManager


class ArticleCAndGController {
    public editor;
    public authoring;

    public ArticleCAndGController(edit, au){
        editor = edit;
        authoring = au;
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
            article =
                    editor.getSubEditor("ArticleEditor").createNewArticleAndPlace(event.getName(), event.getImageName(),
                            x,
                            y,
                            true);
            if(event instanceof HighlightedArticle) {
                authoring.setHighlighted(false);
                Pane p = (Pane) event.getParent();
                p.getChildren().remove(event);
            }
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

}
