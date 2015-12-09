package authoring.ui.draganddrop;

import authoring.controller.AuthoringController;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class HighlightedArticle extends DraggableElement {

    public HighlightedArticle(){};

    public HighlightedArticle(Image img, AuthoringController authoringController) {
        super();
        name = "YOOO";
        imageName = img.toString();
        ImageView i = new ImageView();
        i.setImage(img);
        i.setOpacity(0.0);
        this.setGraphic(i);
        this.getStyleClass().add("Butt");
        super.dragDetected();
        //super.dragEnd();
        init(authoringController);
        //authoringController.callEvent("ArticleExtenderController","init");
    }

    public void init(AuthoringController authoringController){
        this.setOnMouseClicked(event -> authoringController.callEvent("DragAndDropController","tempButtonClick",event));
    }

}

