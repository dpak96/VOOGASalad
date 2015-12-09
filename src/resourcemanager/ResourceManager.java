package resourcemanager;

import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;


public class ResourceManager extends Manager {
  private static ResourceManager resourceManager;
  private Map<String, Manager> managerMap;
  private ResourceBundle paths;

  private ResourceManager() {
    filePath = "resources/path";
    paths = ResourceBundle.getBundle(filePath);
    managerMap = new HashMap<String, Manager>();
    initResources();
  }

  public void initResources() {
    managerMap.put("PropertiesManager",
                   new PropertiesManager(paths.getString("PropertiesManager")));
    managerMap.put("ImageManager", new ImageManager(paths.getString("ImageManager")));
    managerMap.put("SoundManager", new SoundManager(paths.getString("SoundManager")));
    managerMap.put("BackgroundImageManager", new ImageManager(paths.getString("BackgroundImageManager")));
    managerMap.put("ArticleImageManager", new ImageManager(paths.getString("ArticleImageManager")));
    managerMap.put("PlatformImageManager", new ImageManager(paths.getString("PlatformImageManager")));

  }
  public void refreshImages(){
     ImageManager backgroundManager=(ImageManager) managerMap.get("BackgroundImageManager");
     System.out.println(backgroundManager.getObjectMap().size());
     backgroundManager.initListImages();
     System.out.println(backgroundManager.getObjectMap().size());
     ImageManager articleManager=(ImageManager) managerMap.get("ArticleImageManager");
     articleManager.initListImages();
     ImageManager platformManager=(ImageManager) managerMap.get("PlatformImageManager");
     platformManager.initListImages();
  }
  public static ResourceManager getResourceManager() {
    if (resourceManager == null) {
      resourceManager = new ResourceManager();
    }
    return resourceManager;
  }

  public static void setResourceManager(ResourceManager resourceManager) {
    ResourceManager.resourceManager = resourceManager;
  }

  public Object getResource(String manager, String name) {
    return ResourceManager.getResourceManager().managerMap.get(manager).getObjectMap().get(name);
  }

  public Map<String, Object> getResourceMap(String manager) {
    return ResourceManager.getResourceManager().managerMap.get(manager).getObjectMap();
  }

}
