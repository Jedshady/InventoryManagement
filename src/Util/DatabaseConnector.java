/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jedshady
 */
public class DatabaseConnector {

	public static Connection getConnection() {

		Connection con = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/inventory_admin?verifyServerCertificate=false&useSSL=true", "root", "root");
		} catch (SQLException ex) {
			Logger.getLogger(DatabaseConnector.class.getName()).log(Level.SEVERE, null, ex);
		}

		return con;
	}

}
