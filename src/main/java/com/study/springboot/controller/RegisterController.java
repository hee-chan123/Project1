package com.study.springboot.controller;

import javax.sql.DataSource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.service.RegisterRequest;
import com.study.springboot.service.StudentRegisterService;
import com.study.springboot.spring.DuplicateStudentException;
import com.study.springboot.spring.StudentDao;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class RegisterController {
	@Autowired
	private StudentDao studentDao;
	@Autowired
	private StudentRegisterService studentRegisterService;
	
	public void setStudentRegisterService(StudentRegisterService studentRegisterService) {
		this.studentRegisterService = studentRegisterService;
	}
	
	@Autowired
	public RegisterController(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	@RequestMapping("/register/step1")
	public String handleStep1() {
		return "register/step1";
	}

	@PostMapping("/register/step2")
	public String handleStep2(
			@RequestParam(value = "agree", defaultValue = "false") Boolean agree,
			Model model) {
		if (!agree) {
			return "register/step1";
		}
		model.addAttribute("registerRequest", new RegisterRequest());
		return "register/step2";
	}

	@GetMapping("/register/step2")
	public String handleStep2Get() {
		return "redirect:/register/step1";
	}

	@PostMapping("/register/step3")
	public String handleStep3(@ModelAttribute("registerRequest") @Valid RegisterRequest regReq, Errors errors) {
		log.info("------------"+ regReq);
		//new RegisterRequestValidator().validate(regReq, errors);
		if (errors.hasErrors()) 
		{
			log.info("------------여기");
			return "register/step2";
		}
			

		try {
			studentRegisterService.regist(regReq);
			return "register/step3";
		} catch (DuplicateStudentException ex) {
			errors.rejectValue("email", "duplicate");
			return "register/step2";
		}
	}
	
	@GetMapping("/index2")
	public String index2() {
		return "index2";
	} 
}
	

