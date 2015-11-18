package resourcemanager;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.scene.image.Image;

public class ImageManager {
  private final String PROPERTIES_PATH = "resources/images/";
  private Map<String, Image> imageMap;
  
  public void initListImages() {
    imageMap = new HashMap<String, Image>();
    File[] folder = new File(PROPERTIES_PATH).listFiles();
    for (File f : folder) {
      Image temp = new Image(getClass().getClassLoader().getResourceAsStream(PROPERTIES_PATH + f.getName()));
      imageMap.put(f.getName().split("\\.")[0], temp);
    }
  }
  
  public Map<String, Image> getImageMap() {
    return imageMap;
  }

  public void setImageMap(Map<String, Image> imageMap) {
    this.imageMap = imageMap;
  }
}
