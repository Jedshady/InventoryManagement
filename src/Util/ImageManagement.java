/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author jedshady
 */
public class ImageManagement {

	public ImageManagement() {
	}
	
	public ImageIcon ResizeImage(String imagePath, byte[] pic, int width, int height) {
        ImageIcon myImage = null;
        
        if(imagePath != null) {
            myImage = new ImageIcon(imagePath);
        } else {
            myImage = new ImageIcon(pic);
        }
        
        Image img = myImage.getImage();
        Image img2 = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(img2);
        return image;
    }
	
}
