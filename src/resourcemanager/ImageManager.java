package resourcemanager;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.scene.image.Image;

public class ImageManager extends Manager {

	public ImageManager(String path) {
		filePath = path;

		this.initListImages();
	}

	public void initListImages() {
		objectMap = new HashMap<String, Object>();
		File[] folder = new File("src/" + filePath).listFiles();
		if (folder != null) {
			for (File f : folder) {
				System.out.println(f.getName());
				Image temp = new Image(getClass().getClassLoader().getResourceAsStream(filePath + f.getName()));
				objectMap.put(f.getName().split("\\.")[0], temp);
			}
		}
	}

}
