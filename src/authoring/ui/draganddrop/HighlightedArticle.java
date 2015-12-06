package authoring.ui.draganddrop;

import authoring.controller.AuthoringController;
import authoring.ui.AuthoringUI;
import authoring.ui.editingmenus.ArticlePropertyEditorMenu;
import authoring.ui.smalloverlay.OverlayController;
import authoring.ui.toolbar.ButtonOverlay;
import authoring.ui.toolbar.ToolbarButton;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.article.Article;
import resourcemanager.ResourceManager;


public class HighlightedArticle extends DraggableElement {
    private double X;
    private double Y;

    public HighlightedArticle(){};


    public HighlightedArticle(String img, AuthoringController authoringController) {
        super();
        name = "YOOO";
        imageName = img;
        ImageView i = new ImageView();
        i.setImage((Image) ResourceManager.getResourceManager().getResource("ImageManager", img));
        this.setGraphic(i);
        this.getStyleClass().add("Butt");
        super.dragDetected();
        super.dragEnd();
        this.setOnMouseClicked(event -> producePopup(event, authoringController));
        authoringController.init();
    }

    public void producePopup(MouseEvent e, AuthoringController authoringController){
        authoringController.tester(e);
        X = e.getScreenX();
        Y = e.getY();
    }

    public double getClickX(){
        return X;
    }
    public double getClickY(){
        return Y;
    }

}

