package resourcemanager;

import java.util.ResourceBundle;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;


public class ResourceManager {
  private static ResourceManager resourceManager;
  private PropertiesManager propertiesManager;
  private ImageManager imageManager;
  private SoundManager soundManager;

  private ResourceManager() {
    propertiesManager = new PropertiesManager();
    imageManager = new ImageManager();
    soundManager = new SoundManager();
    initResources();
  }

  public void initResources() {
    propertiesManager.initListResources();
    imageManager.initListImages();
    soundManager.initListSounds();
  }

  public PropertiesManager getPm() {
    return propertiesManager;
  }

  public void setPm(PropertiesManager pm) {
    this.propertiesManager = pm;
  }

  public ImageManager getIm() {
    return imageManager;
  }

  public void setIm(ImageManager im) {
    this.imageManager = im;
  }

  public SoundManager getSm() {
    return soundManager;
  }

  public void setSm(SoundManager sm) {
    this.soundManager = sm;
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

  public Image getImage(String s) {
    return ResourceManager.getResourceManager().getIm().getImageMap().get(s);
  }

  public ResourceBundle getBundle(String s) {
    return ResourceManager.getResourceManager().getPm().getResourceMap().get(s);
  }

  public AudioClip getAudio(String s) {
    return ResourceManager.getResourceManager().getSm().getSoundMap().get(s);

  }

}
