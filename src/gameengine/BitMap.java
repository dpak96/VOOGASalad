package gameengine;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;

import javax.swing.ImageIcon;

public class BitMap {
	private int[][] myByteArray;
	public BitMap(String myImage) {
		Image image = new ImageIcon(myImage).getImage();

		boolean hasAlpha = false;
		if(image instanceof BufferedImage) {
			BufferedImage bimage = (BufferedImage) image;
			hasAlpha = bimage.getColorModel().hasAlpha();
			myByteArray = makeByteArray(bimage);
		}
	}
	
	public int[][] getByteArray() {
		return myByteArray;
	}
	
	private static int[][] makeByteArray(BufferedImage image) {

	      final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
	      final int width = image.getWidth();
	      final int height = image.getHeight();
	      final boolean hasAlphaChannel = image.getAlphaRaster() != null;

	      int[][] result = new int[height][width];
	      if (hasAlphaChannel) {
	         final int pixelLength = 4;
	         for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
	            int argb = 0;
	            argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
	            argb += ((int) pixels[pixel + 1] & 0xff); // blue
	            argb += (((int) pixels[pixel + 2] & 0xff) << 8); // green
	            argb += (((int) pixels[pixel + 3] & 0xff) << 16); // red
	            result[row][col] = argb;
	            col++;
	            if (col == width) {
	               col = 0;
	               row++;
	            }
	         }
	      } 

	      return result;
	   }
	
}
