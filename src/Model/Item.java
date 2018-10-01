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
public class Item {
	private int id;
    private String name;
    private float price;
    private int quantity;
    private String picture;
	private String category;
	
	public Item() {
	}
    
    public Item(int pid, String pname, float pprice, int pquantity, String pimg, String pcategory) {
        this.id = pid;
        this.name = pname;
        this.price = pprice;
        this.quantity = pquantity;
        this.picture = pimg;
		this.category = pcategory;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public float getPrice() {
        return price;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public String getPicture() {
        return picture;
    }

	public String getCategory() {
		return category;
	}
}
