package authoring.ui.smalloverlay;

import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class OverlayController extends StackPane {

    protected StackPane base;
    protected ArrayList<Pane> overlays;

    public OverlayController(){
        this(new StackPane());
    }

    public OverlayController(StackPane b){
        overlays = new ArrayList<>();
        getStyleClass().add("BaseP");
    }

    public void addPane(Pane n){
        overlays.add(n);
        getChildren().add(n);
    }

    public void addOverlay(Pane ov){
        Pane cover = new Pane();
        cover.getStyleClass().addAll("Overlayed");
        getChildren().add(cover);
        overlays.add(cover);
        overlays.add(ov);
        getChildren().add(ov);
    }

    public Pane getModule(){
        return base;
    }

    public void removeTop(){
        if(overlays.size()>0) {
            int last = getChildren().size()-1;
            getChildren().remove(last);
            getChildren().remove(last-1);
        }
    }

    public void removePane(Pane n){
        getChildren().remove(n);
    }

    public void removeTopAndtoggleOverlay(){
        removeTop();
        if(overlays.size()>0) {
            for(int x= 0; x<overlays.size(); x++){
                overlays.get(x).getStyleClass().remove("Overlayed");
            }
        }

    }

}
