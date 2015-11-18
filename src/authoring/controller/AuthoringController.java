package authoring.controller;

import authoring.backend.Editor;
import authoring.ui.AuthoringUI;
import javafx.geometry.Point2D;


public class AuthoringController implements IAuthoringController {
  private Editor editor;
  private AuthoringUI ui;

  public Editor getEditor() {
    return editor;
  }

  public void setEditor(Editor editor) {
    this.editor = editor;
  }

  public AuthoringUI getUi() {
    return ui;
  }

  public void setUi(AuthoringUI ui) {
    this.ui = ui;
  }

  public Point2D getMouseCoordinates(){
    
    this.getUi().getDragAndDrop()
    return null;
    
  }
}
