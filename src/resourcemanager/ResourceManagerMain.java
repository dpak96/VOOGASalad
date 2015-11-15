package resourcemanager;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

public class ResourceManagerMain {

  public static void main(String[] args) {
    PropertiesManager pm = new PropertiesManager();
    pm.initListResources();
    System.out.println(pm.getResourceMap().get("error").getString("test"));
    System.out.println(pm.getResourceMap().get("game").getString("test"));
    
    ImageManager im = new ImageManager();
    im.initListImages();
    
    SoundManager sm = new SoundManager();
    sm.initListSound();
    sm.getSoundMap().get("rayGunWav").play();
    System.out.println("bleh");

  }
}
