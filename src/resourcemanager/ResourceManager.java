package resourcemanager;

public class ResourceManager {
  private PropertiesManager pm;
  private ImageManager im;
  private SoundManager sm;

  public ResourceManager() {
    pm = new PropertiesManager();
    im = new ImageManager();
    sm = new SoundManager();
  }

  public void initResources() {
    pm.initListResources();
    im.initListImages();
    sm.initListSounds();
  }

  public PropertiesManager getPm() {
    return pm;
  }

  public void setPm(PropertiesManager pm) {
    this.pm = pm;
  }

  public ImageManager getIm() {
    return im;
  }

  public void setIm(ImageManager im) {
    this.im = im;
  }

  public SoundManager getSm() {
    return sm;
  }

  public void setSm(SoundManager sm) {
    this.sm = sm;
  }

}
