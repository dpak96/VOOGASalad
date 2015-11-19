package authoring.controller;

import authoring.backend.Editor;
import authoring.ui.AuthoringUI;
import javafx.event.Event;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;


public class AuthoringController implements IAuthoringController {
  private Editor editor;
  private AuthoringUI ui;

  public AuthoringController(){
    ui = new AuthoringUI(this);
    editor = new Editor();
  }

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

  public void createArticleFromDragAndDrop(double x, double y, Object event){
    System.out.print(x);
    System.out.print(y);
    System.out.print(event);
    editor.getArticleEditor().createNewArticleAndPlace("placeholder", imageFileName, x, y, true);
    
  }
}
