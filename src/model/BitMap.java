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

	public BitMap(String myImage) {
		System.out.println(myImage);
		Image image = new Image(getClass().getClassLoader().getResourceAsStream(myImage));
		BufferedImage bfImage = SwingFXUtils.fromFXImage(image, null);
		BufferedImage convertedImg = new BufferedImage(bfImage.getWidth(), bfImage.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
	    convertedImg.getGraphics().drawImage(bfImage, 0, 0, null);
		myBitMap = makeBitMap(convertedImg);
	}

	public int[][] getByteArray() {
		return myBitMap;
	}

	private static int[][] makeBitMap(BufferedImage image) {
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
//	      if (hasAlphaChannel) {
//	    	  System.out.println("alpha channel");
//	          final int pixelLength = 4;
//	          for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
//	             int argb = 0;
//	             int alpha = image.getRGB(col,row);
//	             if( (alpha>>24) == 0x00 ) {
//	                 result[row][col] = 1;
//	             } else {
//	            	 result[row][col] = 0;
//	             }
////	             argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
////	             argb += ((int) pixels[pixel + 1] & 0xff); // blue
////	             argb += (((int) pixels[pixel + 2] & 0xff) << 8); // green
////	             argb += (((int) pixels[pixel + 3] & 0xff) << 16); // red
////	             result[row][col] = argb;
//	             col++;
//	             if (col == width) {
//	                col = 0;
//	                row++;
//	             }
//	          }
//	       } else {
//	    	   System.out.println("No alpha channel");
//	          final int pixelLength = 3;
//	          for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
//	             int argb = 0;
//	             argb += -16777216; // 255 alpha
////	             argb += ((int) pixels[pixel] & 0xff); // blue
////	             argb += (((int) pixels[pixel + 1] & 0xff) << 8); // green
////	             argb += (((int) pixels[pixel + 2] & 0xff) << 16); // red
//	             result[row][col] = argb;
//	             col++;
//	             if (col == width) {
//	                col = 0;
//	                row++;
//	             }
//	          }
//	       }
	      return result;	}

}
