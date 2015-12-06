package authoring.backend

import model.controller.ModelController;
import resourcemanager.ResourceManager

import java.lang.reflect.Constructor;


public class EditorManager extends Editor {
  private GameEditor gameEditor;
  private ArticleEditor articleEditor;
  private UserInterfaceEditor userInterfaceEditor;
  private LevelEditor levelEditor;
  private Map<String, Editor> editorMap;


  public EditorManager(ModelController modelController) {
    super(modelController);
    this.register(modelController);
    setGameEditor(new GameEditor(modelController));
    setLevelEditor(new LevelEditor(modelController));
    setArticleEditor(new ArticleEditor(modelController));
  }
  
  public void register(ModelController mc){
    ResourceBundle rb = (ResourceBundle) ResourceManager.getResourceManager().getResource("PropertiesManager", "Reflection");
    editorMap = new HashMap<String, Editor>();
    for(String x: rb.keySet()){
      editorMap.put(x, getNewInstance(rb.getString(x)));
    }

    /*editorMap.put("GameEditor", getNewInstance());
    editorMap.put("UserInterfaceEditor", new UserInterfaceEditor(mc));
    editorMap.put("LevelEditor", new LevelEditor(mc));
    editorMap.put("ArticleEditor", new ArticleEditor(mc));*/
  }

  private getNewInstance(String cName){
    Class<?> cl = Class.forName(cName);
    Constructor<?> ctor = cl.getConstructor(ModelController.class);
    Object[] o = new Object[1];
    o[0] = myModelController;
    Object object = ctor.newInstance(o);
    return object;
  }


  public GameEditor getGameEditor() {
    return gameEditor;
  }

  public getSubEditor(String editor){
    return editorMap.get(editor);
  }

  public void setGameEditor(GameEditor gameEditor) {
    this.gameEditor = gameEditor;
  }

  public UserInterfaceEditor getUserInterfaceEditor() {
    return userInterfaceEditor;
  }

  public void setUserInterfaceEditor(UserInterfaceEditor userInterfaceEditor) {
    this.userInterfaceEditor = userInterfaceEditor;
  }

  public LevelEditor getLevelEditor() {
    return levelEditor;
  }

  public void setLevelEditor(LevelEditor levelEditor) {
    this.levelEditor = levelEditor;
  }

  public ArticleEditor getArticleEditor() {
    return articleEditor;
  }

  public void setArticleEditor(ArticleEditor articleEditor) {
    this.articleEditor = articleEditor;
  }


}
