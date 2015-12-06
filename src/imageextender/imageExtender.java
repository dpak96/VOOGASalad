package imageextender;

import java.awt.image.BufferedImage;

import javafx.scene.image.Image;

public class imageExtender {
	public Image extendImage(int times, Image im){
		Image ans = null;
		int w = (int) im.getWidth();
		int h = (int) im.getHeight();
		BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

		
		return ans;
	}
}
