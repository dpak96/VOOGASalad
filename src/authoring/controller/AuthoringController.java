package authoring.controller;

import authoring.backend.Editor;
import authoring.ui.AuthoringUI;
import authoring.ui.toolbar.PlatformButton;
import authoring.ui.toolbar.ToolbarButton;
import javafx.event.Event;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import model.controller.ModelController;


public class AuthoringController implements IAuthoringController {
  private Editor editor;
  private AuthoringUI ui;
  private ModelController modelController;

  public AuthoringController(ModelController mc) {
    ui = new AuthoringUI(this);
    modelController = mc;
    editor = new Editor(mc);
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

  public void createAndPlaceArticle(double x, double y, ToolbarButton event) {
    editor.getArticleEditor().createNewArticleAndPlace(event.getName(), event.getImageName(), x, y,
                                                       true);

  }

  public PlatformButton getArticleFromCoordinates(double x, double y) {
  try {
    editor.getArticleEditor().setArticle(modelController.getArticleFromCoordinates(x, y));
    PlatformButton pb = new PlatformButton();
    return pb;
  }
  catch (Exception e){
    System.out.print("Oops");
    return null;
  }
  }
  
}
