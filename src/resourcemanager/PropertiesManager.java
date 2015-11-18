package resourcemanager;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


public class PropertiesManager {
  private final String PROPERTIES_PATH = "resources/properties/";
  private Map<String, ResourceBundle> resourceMap;

  public PropertiesManager() {

  }

  public void initListResources() {
    resourceMap = new HashMap<String, ResourceBundle>();
    File[] folder = new File(PROPERTIES_PATH).listFiles();
    for (File f : folder) {
      System.out.println(PROPERTIES_PATH + f.getName().split("\\.")[0]);
      ResourceBundle temp =
          ResourceBundle.getBundle(PROPERTIES_PATH + f.getName().split("\\.")[0]);
              
      resourceMap.put(f.getName().split("\\.")[0], temp);
    }
  }

  public Map<String, ResourceBundle> getResourceMap() {
    return resourceMap;
  }

  public void setResourceMap(Map<String, ResourceBundle> resourceMap) {
    this.resourceMap = resourceMap;
  }

}
