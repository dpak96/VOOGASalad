package authoring.ui.toolbar;

import authoring.ui.editingmenus.RuleMenu;

public class RuleButton extends ToolbarButton {

    public RuleButton(){
        super();
        this.setGraphic(super.setImage(super.toolbarProperties.getString("RULE")));
    }
    @Override
    public void placeYourObject () {
        RuleMenu ruleDialog=new RuleMenu();
        ruleDialog.showMenu("Rule Creator" );
    }

    
}
