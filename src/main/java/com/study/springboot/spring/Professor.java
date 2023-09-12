package com.study.springboot.spring;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor //자동생성기 시발것
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Professor {

	private String pnum; //int -> String
	private String password;
	private String email;
	private String pname;
	private String phone;
	private String addr;
	private String major;

	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword))
			throw new WrongIdPasswordException();
		this.password = newPassword;
	}

	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}

	public void setId(long l) {
	
		
	}
					//int -> String
	public Professor(String pnum, String pname, String addr, String phone, String email, String major) {
		this.pnum = pnum;
		this.email = email;
		this.pname = pname;
		this.phone = phone;
		this.addr = addr;
		this.major = major;
	}
	
	
}
