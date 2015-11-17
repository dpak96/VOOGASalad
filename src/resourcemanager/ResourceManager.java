package resourcemanager;

public class ResourceManager {
  private PropertiesManager propertiesManager;
  private ImageManager imageManager;
  private SoundManager soundManager;

  public ResourceManager() {
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

}
