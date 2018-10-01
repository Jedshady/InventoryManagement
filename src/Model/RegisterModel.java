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
public class RegisterModel {

	private String fname;
	private String lname;
	private String uname;
	private String password;
	private String re_password;
	private String bDate;

	public RegisterModel(String fname, String lname, String uname, String password, String re_password, String bDate) {
		this.fname = fname;
		this.lname = lname;
		this.uname = uname;
		this.password = password;
		this.re_password = re_password;
		this.bDate = bDate;
	}

	public RegisterModel() {
//		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	
	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRe_password(String re_password) {
		this.re_password = re_password;
	}

	public void setbDate(String bDate) {
		this.bDate = bDate;
	}

	public String getFname() {
		return fname;
	}

	public String getLname() {
		return lname;
	}

	public String getUname() {
		return uname;
	}

	public String getPassword() {
		return password;
	}
	
	public String getRe_password() {
		return re_password;
	}

	public String getbDate() {
		return bDate;
	}

}
