package authoring.ui.editingmenus;

import action.controller.ActionController;
import authoring.controller.AuthoringController;
import model.Article;


public abstract class ArticleEditorMenu extends AuthoringMenu {
    public Article objectToEdit;

    public ArticleEditorMenu (String title,AuthoringController myController) {
        super(title,myController);
    }

}
