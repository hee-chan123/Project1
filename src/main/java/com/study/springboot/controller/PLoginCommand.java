package com.study.springboot.controller;

public class PLoginCommand {

	private String Pnum;
	private String password;
	private boolean rememberPnum;

	public String getPnum() {
		return Pnum;
	}

	public void setPnum(String Pnum) {
		this.Pnum = Pnum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password; 
	}

	public boolean getRememberPnum() {
		return rememberPnum;
	}
	public boolean isRememberPnum(boolean rememberPnum) {
		return rememberPnum;
	}


}
