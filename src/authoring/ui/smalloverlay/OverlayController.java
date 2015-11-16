package authoring.ui.smalloverlay;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class OverlayController {

    protected Base myBase;
    protected ArrayList<Overlay> overlays;

    public OverlayController(){
        this(new Base());
    }

    public OverlayController(Base b){
        overlays = new ArrayList<>();
        myBase = b;
    }

    public void addOverlay(Overlay ov){
        overlays.add(ov);
        myBase.addToPane(ov.getPane());
        myBase.toggleOverlayed();
    }

    public Pane getModule(){
        return myBase.getPane();
    }


}
