package authoring.backend;

import model.controller.ModelController;

public class LevelEditor extends Editor {

  public LevelEditor(ModelController mc) {
    super(mc);
    // TODO Auto-generated constructor stub
  }
  
  public void setBackgroundImage(String name){
    myModelController.setBackgroundImage(name);
  }
  

}
