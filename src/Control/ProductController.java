/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.ProductModel;
import Ui.ProductView;
import Util.DatabaseConnector;
import Util.ImageManagement;
import java.awt.event.*;
import java.io.File;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author jedshady
 */
public class ProductController {
	private ProductModel p_model;
	private ProductView p_view;
	private ImageManagement image_manager;
	
	private static ProductController productController = null;

	private ProductController() {
		this.p_model = new ProductModel();
		this.p_view = new ProductView(this);
		this.image_manager = new ImageManagement();
	}
	
	public static ProductController getProductController(){
		if (productController == null) {
			productController = new ProductController();
		}
		return productController;
	}
	
	public void showProductTitle(String title) {
		p_view.getLbl_Title().setText(title);
	}

	public void showBlankView(){
		p_view.getTxt_Name().setText(null);
		p_view.getTxt_Price().setText(null);
		p_view.getTxt_Quantity().setText(null);
		p_view.getWin_Image().setIcon(null);
		
		p_view.setLocationRelativeTo(null);
		p_view.setResizable(false);
		p_view.setVisible(true);
	}
	
	public void showView() {
		p_view.setLocationRelativeTo(null);
		p_view.setResizable(false);
		p_view.setVisible(true);
	}
	
	// Check Input Fields
    public boolean checkInputs() {
        if(p_view.getTxt_Name().getText() == null
            ||  p_view.getTxt_Price().getText() == null
            ||  p_view.getTxt_Quantity().getText() == null) {
			JOptionPane.showMessageDialog(null, "One or more fields are empty.");
            return false;
        } else {
            try {
                Float.parseFloat(p_view.getTxt_Price().getText());
				Integer.parseInt(p_view.getTxt_Quantity().getText());
                return true;
            } catch (NumberFormatException ex) {
				Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
				JOptionPane.showMessageDialog(null, "Price or quantity number is illegal.");
                return false;
            }
        }
    }

	public boolean addNewProduct(){
		if(checkInputs() && p_model.getImagePath() != null){
			PreparedStatement ps;
			String query = "INSERT INTO `products`(`p_name`, `p_price`, `p_quantity`, `p_category`, `p_image`) VALUES (?, ?, ?, ?, ?)";
			
			try {
				ps = DatabaseConnector.getConnection().prepareStatement(query);
				
				ps.setString(1, p_view.getTxt_Name().getText());
				ps.setString(2, p_view.getTxt_Price().getText());
				ps.setString(3, p_view.getTxt_Quantity().getText());
				ps.setString(4, (String) p_view.getCbx_Category().getSelectedItem());
				ps.setString(5, p_model.getImagePath());
				
				if(ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "Product added successfully.");	
				}
				
				return true;
			} catch (SQLException ex) {
				Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
				return false;
			}	
		}
		
		if(p_model.getImagePath() == null){
			JOptionPane.showMessageDialog(null, "Please choose a product image.");
		}
		return false;
	}
	
	public boolean updateSelectedProduct(String id){
		if(checkInputs() && p_model.getImagePath() != null){
			PreparedStatement ps;
			String query = "UPDATE `products` SET `p_name`=?,`p_price`=?,`p_quantity`=?,`p_category`=?,`p_image`=? WHERE `p_id` = ?";
			
			try {
				ps = DatabaseConnector.getConnection().prepareStatement(query);
				
				ps.setString(1, p_view.getTxt_Name().getText());
				ps.setString(2, p_view.getTxt_Price().getText());
				ps.setString(3, p_view.getTxt_Quantity().getText());
				ps.setString(4, (String) p_view.getCbx_Category().getSelectedItem());
				ps.setString(5, p_model.getImagePath());
				ps.setString(6, id);
				
				if(ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "Edit product successfully.");	
				}
				
				return true;
			} catch (SQLException ex) {
				Logger.getLogger(ProductController.class.getName()).log(Level.SEVERE, null, ex);
				return false;
			}	
		}
		
		if(p_model.getImagePath() == null){
			JOptionPane.showMessageDialog(null, "Please choose a product image.");
		}
		return false;
	}
	
	public void showImage(String path){
		int width = p_view.getWin_Image().getWidth();
		int height = p_view.getWin_Image().getHeight();
        p_view.getWin_Image().setIcon(image_manager.ResizeImage(path, null, width, height));
	}
	
	public void btn_ChooseImageActionPerformed(ActionEvent e){
		JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        
		if(result == JFileChooser.APPROVE_OPTION){
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
			showImage(path);
			p_model.setImagePath(path);
        } else {
            System.out.println("No File Selected");	
        }
	}
	
	public void btn_ConfirmActionPerformed(ActionEvent e){
		if("Add new product".equals(p_view.getLbl_Title().getText())){
			System.out.println("Add new product");
			if (addNewProduct()) {
				InventoryController ivc = InventoryController.geInventoryController();
				ivc.updateInventoryTable();
				p_view.dispose();
			}
		} else {
			System.out.println("Update selected product");
			if (updateSelectedProduct(selectedId)){
				InventoryController ivc = InventoryController.geInventoryController();
				ivc.updateInventoryTable();
				p_view.dispose();
			}
		}	
	}
	
	public void btn_CancelActionPerformed(ActionEvent e){
		p_view.dispose();
	}

	private String selectedId;

	public void setSelectedId(String selectedId) {
		this.selectedId = selectedId;
	}
	
	public ProductView getP_view() {
		return p_view;
	}

	public ProductModel getP_model() {
		return p_model;
	}
	
}
