package authoring.controller;

import authoring.backend.Editor;

public class AuthoringController implements IAuthoringController {
  private Editor editor;

  public Editor getEditor() {
    return editor;
  }

  public void setEditor(Editor editor) {
    this.editor = editor;
  }
}
