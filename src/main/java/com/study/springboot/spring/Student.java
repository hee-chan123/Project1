package com.study.springboot.spring;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor //자동생성기
@Getter
@Setter
@ToString
public class Student {

	private String snum; //int -> String 
	private String password;
	private String email;
	private String sname;
	private String phone;
	private String addr;
	private String grade; //int-> String
	private String status;
	private String major;

	public void changePassword(String oldPassword, String newPassword) {
		if (!password.equals(oldPassword))
			throw new WrongIdPasswordException();
		this.password = newPassword;
	}

	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}

	public void setId(String l) {
	
		
	}
	
	
}
