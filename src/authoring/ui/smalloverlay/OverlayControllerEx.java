package authoring.ui.smalloverlay;

import javafx.scene.control.Button;

/**
 * Created by Rob on 11/16/15.
 */
public class OverlayControllerEx extends OverlayController {

    public OverlayControllerEx(){
        super();
    }


    public void init(){
        Button button = new Button("Switch");
        Overlay ov = new Overlay();
        addOverlay(ov);
    }











}
