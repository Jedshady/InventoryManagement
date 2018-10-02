/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Model.LoginModel;
import Ui.LoginView;
import Util.DatabaseConnector;
import java.awt.event.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;

/**
 *
 * @author jedshady
 */
public class LoginController {
	private LoginModel l_model;
	private LoginView l_view;

	public LoginController() {
		this.l_model = new LoginModel();
		this.l_view = new LoginView(this);
	}

	public void showView() {
		l_view.setLocationRelativeTo(null);
		l_view.setResizable(false);
		l_view.setVisible(true);
	}
	
	
	public boolean checkInputs(){
		boolean isLegal = true;
		if(l_view.getTxt_Username().getText().equals("")){
			JOptionPane.showMessageDialog(null, "Please insert a username.");
			isLegal = false;
		} else if (String.valueOf(l_view.getPsw_Password().getPassword()).equals("")){
			JOptionPane.showMessageDialog(null, "You must input a password!");
			isLegal = false;
		} 
		return isLegal;
	}
	
	public void updateModel(){
		l_model.setUname(l_view.getTxt_Username().getText());
		l_model.setPassword(String.valueOf(l_view.getPsw_Password().getPassword()));
	}

	public void btn_SignInActionPerformed(ActionEvent e) {
		
		if(checkInputs()){
			updateModel();
			
			PreparedStatement ps;
			ResultSet rs;
			
			String query = "SELECT * FROM `users` WHERE `u_uname` = ? AND `u_pass` = ?";
			
			try {
				ps = DatabaseConnector.getConnection().prepareStatement(query);
				
				ps.setString(1, l_model.getUname());
				ps.setString(2, l_model.getPassword());
				
				rs = ps.executeQuery();
				
				if(rs.next()){
					JOptionPane.showMessageDialog(null, "Sign in successfully. Welcome!");
					l_view.dispose();
					InventoryController ivc = InventoryController.geInventoryController();
					ivc.setWelcomePanel(l_model.getUname());
					ivc.showView();	
				} else {
					JOptionPane.showMessageDialog(null, "Incorrect username or password.", "Login failed", WARNING_MESSAGE);
				}
			} catch (SQLException ex) {
				Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public void btn_SignUpActionPerformed(ActionEvent e) {
		RegisterController rgc = RegisterController.getRegisterController();
		rgc.showView();
	}

}
