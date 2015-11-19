package authoring.ui.editingmenus;

import action.controller.ActionController;
import authoring.controller.AuthoringController;
import model.Article;


public abstract class ArticleEditorMenu extends AuthoringMenu {
    protected Article objectToEdit;

    public ArticleEditorMenu (String title, Article selectedArticle,AuthoringController myController) {
        super(title,myController);
        objectToEdit = selectedArticle;
    }

}
