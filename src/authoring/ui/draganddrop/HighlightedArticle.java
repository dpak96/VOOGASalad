package authoring.ui.draganddrop;

import authoring.ui.AuthoringUI;
import authoring.ui.editingmenus.ArticlePropertyEditor;
import authoring.ui.smalloverlay.OverlayController;
import authoring.ui.toolbar.ButtonOverlay;
import authoring.ui.toolbar.ToolbarButton;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import model.Article;
import resourcemanager.ResourceManager;


public class HighlightedArticle extends DraggableElement {


    public HighlightedArticle(String img) {
        super();
        name = "YOOO";
        imageName = img;
        ImageView i = new ImageView();
        i.setImage(ResourceManager.getResourceManager().getImage(img));
        this.setGraphic(i);
        this.getStyleClass().add("Butt");
        super.dragDetected();
        super.dragEnd();
    }


}

