package com.study.springboot.auth;

public class AuthInfo {

	private String snum;
	private String password;
	private String email;
	private String sname;
	private String phone;
	private String addr;
	private String grade;
	private String status;
	private String major;
	
	public AuthInfo(String snum, String password, String sname) {
		this.snum = snum;
		this.password = password;
		this.sname = sname;
	}

	public String getSnum() {
		return snum;
	}

	public String getEmail() {
		return email;
	}

	public String getSname() {
		return sname;
	}

}
