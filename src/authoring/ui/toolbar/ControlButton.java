package authoring.ui.toolbar;

public class ControlButton extends ToolbarButton {

    public ControlButton(){
        super();
        this.setGraphic(this.setImage(super.toolbarProperties.getString("KEYS")));
    }
    
    @Override
    public void placeYourObject () {
        // TODO Auto-generated method stub

    }

}
