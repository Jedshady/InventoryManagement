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
public class LoginModel {
	private String uname;
	private String password;

	public LoginModel() {
	}

	public LoginModel(String uname, String password) {
		this.uname = uname;
		this.password = password;
	}

	public String getUname() {
		return uname;
	}

	public String getPassword() {
		return password;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
