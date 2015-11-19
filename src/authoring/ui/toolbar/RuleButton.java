package authoring.ui.toolbar;

import authoring.controller.AuthoringController;
import authoring.ui.editingmenus.RuleMenu;

public class RuleButton extends ToolbarButton {
    public RuleButton(AuthoringController myController){
        super(myController);
        
        this.setGraphic(super.setImage(super.toolbarProperties.getString("RULE")));
    }
    @Override
    public void placeYourObject () {
        if(super.myController==null)
            System.out.println("null");
        RuleMenu ruleDialog=new RuleMenu("Rule Menu",super.myController);
    }

    
}
