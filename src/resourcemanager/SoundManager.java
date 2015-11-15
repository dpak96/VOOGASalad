package resourcemanager;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;


public class SoundManager {
  private final String PROPERTIES_PATH = "resources/sounds/";
  private Map<String, AudioClip> soundMap;

  public void initListSound() {
    soundMap = new HashMap<String, AudioClip>();
    File[] folder = new File("src/" + PROPERTIES_PATH).listFiles();
    for (File f : folder) {
      File tempFile = new File("src/" + PROPERTIES_PATH + f.getName());
      AudioClip temp = new AudioClip(tempFile.toURI().toString());
      soundMap.put(f.getName().split("\\.")[0], temp);
    }
  }

  public Map<String, AudioClip> getSoundMap() {
    return soundMap;
  }

  public void setSoundMap(Map<String, AudioClip> soundMap) {
    this.soundMap = soundMap;
  }
}
