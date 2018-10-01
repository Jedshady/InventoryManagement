/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author jedshady
 */
public class ProductModel {
	private String imagePath;
	private Item item;

	public ProductModel() {
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void setItem(Item item) {
		this.item = item;
	}
	
}
