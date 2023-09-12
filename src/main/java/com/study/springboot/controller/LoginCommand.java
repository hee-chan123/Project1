package com.study.springboot.controller;

public class LoginCommand {

	private String Snum;
	private String password;
	private boolean rememberSnum;

	public String getSnum() {
		return Snum;
	}

	public void setSnum(String Snum) {
		this.Snum = Snum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password; 
	}

	public boolean getRememberSnum() {
		return rememberSnum;
	}
	public boolean isRememberSnum(boolean rememberSnum) {
		return rememberSnum;
	}


}
