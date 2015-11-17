package authoring.ui.smalloverlay;

import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class OverlayController {

    protected StackPane base;
    protected ArrayList<Pane> overlays;

    public OverlayController(){
        this(new StackPane());
    }

    public OverlayController(StackPane b){
        overlays = new ArrayList<>();
        base = b;
        base.getStyleClass().add("BaseP");
        overlays.add(base);
    }

    public void addPane(Pane n){
        overlays.add(n);
        base.getChildren().add(n);
    }

    public void addOverlay(Pane ov){

        if(overlays.size()>0){
            overlays.get(overlays.size()-1).getStyleClass().add("Overlayed");
        }
        overlays.add(ov);
        base.getChildren().add(ov);
    }

    public Pane getModule(){
        return base;
    }

    public void removeTop(){
        if(overlays.size()>0) {
            Pane last = overlays.get(overlays.size() - 1);
            base.getChildren().remove(last);
        }
    }

    public void removePane(Pane n){
        base.getChildren().remove(n);
    }

    public void removeTopAndtoggleOverlay(){
        removeTop();
        if(overlays.size()>0) {
            int last = overlays.size() - 1;
            overlays.get(last).getStyleClass().remove("Overlayed");
        }

    }

}
