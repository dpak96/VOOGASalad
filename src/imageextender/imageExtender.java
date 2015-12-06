package imageextender;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

public class imageExtender {
	public Image extendImage(int times, Image im){
		java.awt.image.BufferedImage awtIm = SwingFXUtils.fromFXImage(im, null);
		int w = awtIm.getWidth();
		int h = awtIm.getHeight();
		
		BufferedImage combined = new BufferedImage(times*w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics g = combined.getGraphics();
		
		for(int i = 0; i < times; i++){
			g.drawImage(awtIm, i*w, 0, null);
		}

		javafx.scene.image.Image ans = SwingFXUtils.toFXImage(combined, null);		
		return ans;
	}
	
	public void saveImage(java.awt.image.BufferedImage im, String path){
		try {
			ImageIO.write(im, "PNG", new File(path, "combined.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
