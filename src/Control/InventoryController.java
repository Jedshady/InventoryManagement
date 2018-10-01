/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.InventoryModel;
import Model.Item;
import Ui.InventoryView;
import Util.DatabaseConnector;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jedshady
 */
public class InventoryController {
	private InventoryModel i_model;
	private InventoryView i_view;

	private static InventoryController inventoryController = null;
	
	private InventoryController() {
		this.i_model = new InventoryModel();
		this.i_view = new InventoryView(this);
	}
	
	public static InventoryController geInventoryController(){
		if(inventoryController == null){
			inventoryController = new InventoryController();
		}
		
		return inventoryController;
	}
	
	public void showView() {
		i_view.setLocationRelativeTo(null);
		i_view.setResizable(false);
		updateInventoryTable();
		i_view.setVisible(true);
	}

	public void setWelcomePanel(String uname) {
		i_model.setUname(uname);
		i_view.getLbl_Welcome().setText("Welcome " + uname);
	}
	
	// Display Data in JTable:
	// 1 - Fill ArrayList With The Data
	public ArrayList<Item> getItemList() {
		ArrayList<Item> itemList = new ArrayList<>();
		
		Connection con = DatabaseConnector.getConnection();
		String query  = "SELECT * FROM products";
			
		Statement st;
		ResultSet rs;
			
		try {
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			Item item;
			while(rs.next()) {
				item = new Item(rs.getInt("p_id"), rs.getString("p_name"), Float.parseFloat(rs.getString("p_price")), 
						Integer.parseInt(rs.getString("p_quantity")), rs.getString("p_image"), rs.getString("p_category"));
				itemList.add(item);
			}
		} catch (SQLException ex) {
			Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return itemList;
	}
	
	// 2 - Add to JTable
	public void updateInventoryTable() {
		ArrayList<Item> list = getItemList();
		DefaultTableModel model = (DefaultTableModel) i_view.getTbl_Products().getModel();
		
		// clear jtable content
		model.setRowCount(0);
		Object[] row = new Object[5];
		for(int i = 0; i < list.size(); i++) {
			row[0] = list.get(i).getId();
			row[1] = list.get(i).getName();
			row[2] = list.get(i).getPrice();
			row[3] = list.get(i).getQuantity();
			row[4] = list.get(i).getCategory();
 			
			model.addRow(row);
		}
	}
	
	public String getSelectedProductImagePath(String id){
		PreparedStatement ps;
		String query  = "SELECT p_image FROM products WHERE p_id = ?";
		
		ResultSet rs;
		String imgPath = null;	
		try {
			ps = DatabaseConnector.getConnection().prepareStatement(query);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				imgPath = rs.getString("p_image");
			}
		} catch (SQLException ex) {
			Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		return imgPath;	
	} 
	
	public void btn_AddActionPerformed(ActionEvent e){
		ProductController pdc = ProductController.getProductController();
		pdc.showProductTitle("Add new product");
		pdc.showBlankView();
	}
	
	public void btn_EditActionPerformed(ActionEvent e){
		int row = i_view.getTbl_Products().getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(null, "Please select a product you would like to edit.");
		} else {
			DefaultTableModel model = (DefaultTableModel) i_view.getTbl_Products().getModel();
			
			ProductController pdc = ProductController.getProductController();
			pdc.showProductTitle("Update selected product");
			
			pdc.setSelectedId(model.getValueAt(row, 0).toString());
			
			pdc.getP_view().getTxt_Name().setText(model.getValueAt(row, 1).toString());
			pdc.getP_view().getTxt_Price().setText(model.getValueAt(row, 2).toString());
			pdc.getP_view().getTxt_Quantity().setText(model.getValueAt(row, 3).toString());
			pdc.getP_view().getCbx_Category().setSelectedItem(model.getValueAt(row, 4).toString());
		
			String imagePath = getSelectedProductImagePath(model.getValueAt(row, 0).toString());
			pdc.getP_model().setImagePath(imagePath);
			pdc.showImage(imagePath);
			
			pdc.showView();
		}
	}
	
	public void btn_DeleteActionPerformed(ActionEvent e){
		int row = i_view.getTbl_Products().getSelectedRow();
		if(row == -1){
			JOptionPane.showMessageDialog(null, "Please select a product you would like to delete.");
		} else {
			DefaultTableModel model = (DefaultTableModel) i_view.getTbl_Products().getModel();
			String id = model.getValueAt(row, 0).toString();
			
			PreparedStatement ps;
			String query = "DELETE FROM `products` WHERE `p_id`=?";
					
			try {
				ps = DatabaseConnector.getConnection().prepareStatement(query);
				ps.setString(1, id);
				
				if(ps.executeUpdate() > 0){
					JOptionPane.showMessageDialog(null, "Delete successfully.");
					updateInventoryTable();
				}		
			} catch (SQLException ex) {
				Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	
	public void btn_SearchActionPerformed(ActionEvent e){
		String searchString = i_view.getTxt_Query().getText();
		ArrayList<Item> searchedItems = new ArrayList<>();
		
		PreparedStatement ps;
		String query = "SELECT * FROM `products` WHERE CONCAT(`p_id`, `p_name`, `p_price`, `p_quantity`, `p_category`) LIKE '%"+searchString+"%'";
		
		ResultSet rs;
		
		try {
			ps = DatabaseConnector.getConnection().prepareStatement(query);
			rs = ps.executeQuery(query);
			
			Item item;
			
			while(rs.next()){
				item = new Item(rs.getInt("p_id"), rs.getString("p_name"), Float.parseFloat(rs.getString("p_price")), 
						Integer.parseInt(rs.getString("p_quantity")), rs.getString("p_image"), rs.getString("p_category"));
				
				searchedItems.add(item);
			}
			
			DefaultTableModel model = (DefaultTableModel) i_view.getTbl_Products().getModel();
		
			// clear jtable content
			model.setRowCount(0);
			Object[] row = new Object[5];
			for(int i = 0; i < searchedItems.size(); i++) {
				row[0] = searchedItems.get(i).getId();
				row[1] = searchedItems.get(i).getName();
				row[2] = searchedItems.get(i).getPrice();
				row[3] = searchedItems.get(i).getQuantity();
				row[4] = searchedItems.get(i).getCategory();
 			
				model.addRow(row);
			}
			
		} catch (SQLException ex) {
			Logger.getLogger(InventoryController.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public InventoryView getI_view() {
		return i_view;
	}
	
	
}
