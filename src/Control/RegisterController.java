/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.RegisterModel;
import Ui.RegisterView;
import Util.DatabaseConnector;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jedshady
 */
public class RegisterController {

	private RegisterModel r_model;
	private RegisterView r_view;

	private static RegisterController registerController = null;
	
	private RegisterController() {
		this.r_model = new RegisterModel();
		this.r_view = new RegisterView(this);
	}

	public static RegisterController getRegisterController(){
		if(registerController == null){
			registerController = new RegisterController();
		}
		return registerController;
	}
	
	public void showView() {
		r_view.setLocationRelativeTo(null);
		r_view.setResizable(false);
		r_view.setVisible(true);
	}

	public boolean checkInputs(){
		boolean isLegal = true;
		if(r_view.getTxt_Username().getText().equals("")){
			JOptionPane.showMessageDialog(null, "Please add a username.");
			isLegal = false;
		} else if (String.valueOf(r_view.getPsw_Password().getPassword()).equals("")){
			JOptionPane.showMessageDialog(null, "You must set a password!");
			isLegal = false;
		} else if (String.valueOf(r_view.getPsw_RetypePassword().getPassword()).equals("")) {
			JOptionPane.showMessageDialog(null, "Please retype password to confirm.");
			isLegal = false;
		} else if (!Arrays.equals(r_view.getPsw_Password().getPassword(), r_view.getPsw_RetypePassword().getPassword())){
			JOptionPane.showMessageDialog(null, "Retype the password again.");
			isLegal = false;
		}
		return isLegal;
	}
	
	public boolean checkUsername(String username){
		boolean isLegal = true;
		PreparedStatement ps;
		ResultSet rs;
		
		String query = "SELECT * FROM `users` WHERE `u_uname`=?";
		
		try {
			ps = DatabaseConnector.getConnection().prepareStatement(query);
			ps.setString(1, username);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "Username has existed.", "Sign up failed.", JOptionPane.WARNING_MESSAGE);
				isLegal = false;
			}
		} catch (SQLException ex) {
			Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
			isLegal = false;
		}
		return isLegal;
	}
	
	public void updateModel(){	
		r_model.setFname(r_view.getTxt_FirstName().getText());
		r_model.setLname(r_view.getTxt_LastName().getText());
		r_model.setUname(r_view.getTxt_Username().getText());
		r_model.setPassword(String.valueOf(r_view.getPsw_Password().getPassword()));
		r_model.setRe_password(String.valueOf(r_view.getPsw_RetypePassword().getPassword()));
		
		if (r_view.getjDateChooser_Birthday().getDate() != null) {
			SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
			r_model.setbDate(dateformat.format(r_view.getjDateChooser_Birthday().getDate()));
		} else {
			r_model.setbDate(null);
		} 	
	}
	
	public void btn_CancelActionPerformed(ActionEvent e) {
		r_view.dispose();
	}

	public void btn_RegisterActionPerformed(ActionEvent e) {
		if (checkInputs() && checkUsername(r_view.getTxt_Username().getText())){
			updateModel();

			PreparedStatement ps;
			String query = "INSERT INTO `users`(`u_fname`, `u_lname`, `u_uname`, `u_pass`, `u_bdate`) VALUES (?,?,?,?,?)";

			try {
				ps = DatabaseConnector.getConnection().prepareStatement(query);

				ps.setString(1, r_model.getFname());
				ps.setString(2, r_model.getLname());
				ps.setString(3, r_model.getUname());
				ps.setString(4, r_model.getPassword());
				
				if(r_model.getbDate() != null){
					ps.setString(5, r_model.getbDate());
				} else {
					ps.setNull(5, 0);
				}
				
				if(ps.executeUpdate() > 0) {
					JOptionPane.showMessageDialog(null, "Great! You have successfully signed up!");
				}
				
				r_view.dispose();

			} catch (SQLException ex) {
				Logger.getLogger(RegisterController.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

}
