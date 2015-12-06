package imageeditor;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import resourcemanager.ResourceManager;

public class ImageExtender {
	public Image extendImage(String im, double horizontalWidth, double verticalWidth){
		Image img = (Image) ResourceManager.getResourceManager().getResource("ImageManager", im);
		int hTimes = (int) (horizontalWidth/img.getWidth());
		int vTimes = (int) (verticalWidth/img.getHeight());
		java.awt.image.BufferedImage awtIm = SwingFXUtils.fromFXImage(img, null);
		int w = awtIm.getWidth();
		int h = awtIm.getHeight();
		
		BufferedImage combined = new BufferedImage(hTimes*w, vTimes*h, BufferedImage.TYPE_INT_ARGB);
		Graphics g = combined.getGraphics();
		
		for(int i = 0; i < hTimes; i++){
			for(int j = 0; j < vTimes ; j++){
				g.drawImage(awtIm, i*w, j*h, null);
			}
		}

		javafx.scene.image.Image ans = SwingFXUtils.toFXImage(combined, null);		
		return ans;
	}
	
}
