/**
 * @author Calvin	
 */
package model;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class BitMap {
	private int[][] myBitMap;
	

	public BitMap(String myImage, Double x, Double y) {
		System.out.println(myImage);
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(myImage));
		BufferedImage bfImage = SwingFXUtils.fromFXImage(image, null);
		BufferedImage convertedImg = new BufferedImage(bfImage.getWidth(), bfImage.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
	    convertedImg.getGraphics().drawImage(bfImage, 0, 0, null);
		myBitMap = makeBitMap(convertedImg, x, y);
	}

	public int[][] getByteArray() {
		return myBitMap;
	}

	private static int[][] makeBitMap(BufferedImage image, Double x, Double y) {
		System.out.println("making");
		 final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
	      final int width = image.getWidth();
	      final int height = image.getHeight();
	      System.out.println(width + " " + height);
	      final boolean hasAlphaChannel = image.getAlphaRaster() != null;
	      System.out.println(hasAlphaChannel);
	      int[][] result = new int[height][width];
	      
	      for (int i = 0; i < height; i++) {
	          for (int j = 0; j < width; j++) {
	        	  int alpha = image.getRGB(j,i);
		             if( (alpha>>24) == 0x00 ) {
		                 result[i][j] = 1;
		             } else {
		            	 result[i][j] = 0;
		             }
	          }
	        }
	      return result;	}

}
