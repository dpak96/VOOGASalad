package resourcemanager;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.scene.image.Image;
import javafx.scene.media.AudioClip;

public class SoundManager extends Manager {

	public SoundManager(String path) {
		filePath = path;

		this.initListSounds();
	}

	public void initListSounds() {
		objectMap = new HashMap<String, Object>();
		File[] folder = new File("src/" + filePath).listFiles();
		if (folder != null) {

			for (File f : folder) {
				File tempFile = new File("src/" + filePath + f.getName());
				AudioClip temp = new AudioClip(tempFile.toURI().toString());
				objectMap.put(f.getName().split("\\.")[0], temp);
			}
		}
	}

}
