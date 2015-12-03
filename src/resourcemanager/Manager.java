package resourcemanager;

import java.util.Map;

public abstract class Manager {
  protected String filePath;
  protected Map<String, Object> objectMap;


  public String getFile_path() {
    return filePath;
  }

  public void setFile_path(String file_path) {
    this.filePath = file_path;
  }

  public Map<String, Object> getObjectMap() {
    return objectMap;
  }

  public void setObjectMap(Map<String, Object> objectMap) {
    this.objectMap = objectMap;
  } 
  
  
}
