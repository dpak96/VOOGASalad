package authoring.ui.editingmenus;

import model.Article;


public abstract class ArticleEditorMenu extends AuthoringMenu {
    protected Article objectToEdit;

    public ArticleEditorMenu (String title, Article selectedArticle) {
        super(title);
        objectToEdit = selectedArticle;
    }

}
