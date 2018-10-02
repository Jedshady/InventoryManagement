/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ui;

import Control.ProductController;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author jedshady
 */
public class ProductView extends javax.swing.JFrame {
	
	private ProductController p_Controller;
	
	/**
	 * Creates new form ProductView
	 */
	public ProductView(ProductController controller) {
		this.p_Controller = controller;
		initComponents();
		bindEvent();
	}

	
	
	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbl_Title = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lbl_Category = new javax.swing.JLabel();
        lbl_Name = new javax.swing.JLabel();
        lbl_Price = new javax.swing.JLabel();
        lbl_Quantity = new javax.swing.JLabel();
        txt_Name = new javax.swing.JTextField();
        txt_Price = new javax.swing.JTextField();
        txt_Quantity = new javax.swing.JTextField();
        lbl_Image = new javax.swing.JLabel();
        cbx_Category = new javax.swing.JComboBox<>();
        win_Image = new javax.swing.JLabel();
        btn_ChooseImage = new javax.swing.JButton();
        btn_Cancel = new javax.swing.JButton();
        btn_Confirm = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbl_Title.setText("Title");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(lbl_Title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(lbl_Title)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        lbl_Category.setText("Category:");

        lbl_Name.setText("Name:");

        lbl_Price.setText("Price:");

        lbl_Quantity.setText("Quantity:");

        lbl_Image.setText("Image:");

        cbx_Category.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Phone", "Computer", "Tablet" }));

        win_Image.setOpaque(true);

        btn_ChooseImage.setText("Choose Image");

        btn_Cancel.setText("Cancel");

        btn_Confirm.setText("Confirm");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbl_Image)
                            .addComponent(lbl_Quantity)
                            .addComponent(lbl_Price)
                            .addComponent(lbl_Name)
                            .addComponent(lbl_Category))
                        .addGap(79, 79, 79)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_Price)
                                .addComponent(txt_Quantity)
                                .addComponent(txt_Name)
                                .addComponent(cbx_Category, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(win_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btn_Confirm)
                                .addComponent(btn_ChooseImage))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btn_Cancel)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbl_Category)
                    .addComponent(cbx_Category, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Name)
                    .addComponent(txt_Name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Price)
                    .addComponent(txt_Price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Quantity)
                    .addComponent(txt_Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_Image)
                    .addComponent(win_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btn_ChooseImage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Cancel)
                    .addComponent(btn_Confirm))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	public void bindEvent(){
		btn_ChooseImage.addActionListener(p_Controller::btn_ChooseImageActionPerformed);
		btn_Confirm.addActionListener(p_Controller::btn_ConfirmActionPerformed);
		btn_Cancel.addActionListener(p_Controller::btn_CancelActionPerformed);
	}
	
	public JLabel getLbl_Title() {
		return lbl_Title;
	}

	public JLabel getWin_Image() {
		return win_Image;
	}

	public JTextField getTxt_Name() {
		return txt_Name;
	}

	public JTextField getTxt_Price() {
		return txt_Price;
	}

	public JTextField getTxt_Quantity() {
		return txt_Quantity;
	}

	public JComboBox<String> getCbx_Category() {
		return cbx_Category;
	}

	public void setCbx_Category(JComboBox<String> cbx_Category) {
		this.cbx_Category = cbx_Category;
	}

	public void setTxt_Name(JTextField txt_Name) {
		this.txt_Name = txt_Name;
	}

	public void setTxt_Price(JTextField txt_Price) {
		this.txt_Price = txt_Price;
	}

	public void setTxt_Quantity(JTextField txt_Quantity) {
		this.txt_Quantity = txt_Quantity;
	}

	public void setWin_Image(JLabel win_Image) {
		this.win_Image = win_Image;
	}

	
	
	

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Cancel;
    private javax.swing.JButton btn_ChooseImage;
    private javax.swing.JButton btn_Confirm;
    private javax.swing.JComboBox<String> cbx_Category;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbl_Category;
    private javax.swing.JLabel lbl_Image;
    private javax.swing.JLabel lbl_Name;
    private javax.swing.JLabel lbl_Price;
    private javax.swing.JLabel lbl_Quantity;
    private javax.swing.JLabel lbl_Title;
    private javax.swing.JTextField txt_Name;
    private javax.swing.JTextField txt_Price;
    private javax.swing.JTextField txt_Quantity;
    private javax.swing.JLabel win_Image;
    // End of variables declaration//GEN-END:variables
}
