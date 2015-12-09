/**
 * @author Calvin	
 */
package model;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.image.Image;
import model.article.Position;
import resourcemanager.ResourceManager;

import java.awt.image.BufferedImage;

public class BitMap {
	private Position[][] myBitMap;
	
	

	public BitMap(String myImage, Double x, Double y) {
		
		Image image = (Image) ResourceManager.getResourceManager().getResource("ImageManager", myImage);
		BufferedImage bfImage = SwingFXUtils.fromFXImage(image, null);
		BufferedImage convertedImg = new BufferedImage(bfImage.getWidth(), bfImage.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
	    convertedImg.getGraphics().drawImage(bfImage, 0, 0, null);
		myBitMap = makeBitMap(convertedImg, x, y);
	}

	public Position[][] getByteArray() {
		return myBitMap;
	}
	

	private static Position[][] makeBitMap(BufferedImage image, Double x, Double y) {
	      final int width = image.getWidth();
	      final int height = image.getHeight();
	      final boolean hasAlphaChannel = image.getAlphaRaster() != null;
	      Position[][] result = new Position[height][width];
	      
	      for (int i = 0; i < height; i++) {
	          for (int j = 0; j < width; j++) {
	        	  int alpha = image.getRGB(j,i);
		             if( (alpha>>24) == 0x00 ) {
		                 result[i][j] = new Position(-1,-1);
		             } else {
		            	 result[i][j] = new Position(x+j, y+i) ;
		             }
	          }
	        }
	      return result;	}

}
