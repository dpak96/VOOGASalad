package authoring.ui.draganddrop;

import authoring.ui.AuthoringUI;
import authoring.ui.editingmenus.EnemyProperties;
import authoring.ui.smalloverlay.OverlayController;
import authoring.ui.toolbar.ButtonOverlay;
import authoring.ui.toolbar.ToolbarButton;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class HighlightedArticle extends ToolbarButton {
    private final String NAME = "NOTHING";

    public HighlightedArticle() {
        super();
        this.setGraphic(super.setImage(toolbarProperties.getString(NAME)));
        this.getStyleClass().add("Butt");
        this.setName(NAME);
        this.setImageName("TEST");
    }

    @Override
    public void placeYourObject () {
        //EnemyProperties propTest=new EnemyProperties();
        //propTest.showMenu("Enemy Property Editor");
        //OverlayController oc = (OverlayController) this.getParent().getParent();
        //oc.addOverlay(bo.init());
    }
}

