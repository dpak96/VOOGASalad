package authoring.ui.toolbar;

public class BackgroundButton extends ToolbarButton {

    public  BackgroundButton() {
        super();
        this.setGraphic(super.setImage(super.toolbarProperties.getString("BACKGROUND")));
    }
    @Override
    public void placeYourObject () {
        // TODO Auto-generated method stub
        
    }

}
