package com.study.springboot.auth;

public class PAuthInfo {

	private String pnum;
	private String password;
	private String email;
	private String pname;
	private String phone;
	private String addr;
	private String major;
	
	public PAuthInfo(String pnum, String password, String pname) {
		this.pnum = pnum;
		this.password = password;
		this.pname = pname;
	}

	public String getPnum() {
		return pnum;
	}

	public String getEmail() {
		return email;
	}

	public String getPname() {
		return pname;
	}

}
