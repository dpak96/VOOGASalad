package resourcemanager;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;


public class PropertiesManager extends Manager {

  public PropertiesManager(String path) {
    filePath = path;
    this.initListResources();
  }

  public void initListResources() {
    objectMap = new HashMap<String, Object>();
    File[] folder = new File("src/" + filePath).listFiles();
    for (File f : folder) {
      ResourceBundle temp =
          ResourceBundle.getBundle(filePath + f.getName().split("\\.")[0]);

      objectMap.put(f.getName().split("\\.")[0], temp);
    }
  }


}
