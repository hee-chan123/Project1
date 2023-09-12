package com.study.springboot.service;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RegisterRequest {

	@NotNull
	private String snum ;
	@Size(min=6)
	private String password;
	@NotEmpty
	private String confirmPassword;
	@NotEmpty
	private String sname;
	@NotEmpty
	private String addr;
	@NotEmpty
	private String phone;
	@NotEmpty
	private String email;
	//@NotEmpty
	private String grade;
	@NotEmpty
	private String status;
	@NotEmpty
	private String major;
	

}
