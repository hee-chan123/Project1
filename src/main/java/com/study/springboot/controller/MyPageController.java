package com.study.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.spring.Professor;
import com.study.springboot.spring.ProfessorDao;
import com.study.springboot.spring.Student;
import com.study.springboot.spring.StudentDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MyPageController {

	@Autowired
	private ProfessorDao professorDao;

	@Autowired
	private StudentDao studentDao;
	
//	@GetMapping("/main")
//	public String test1232() {
//		return "/main";
//	}
	
	@GetMapping("/mypage/idin")
	public String idin(@RequestParam(value = "id",defaultValue = "")String id, HttpSession session) {
		if(id.equals("") || id == null) {
			return "redirect:/main";
		} 
//		session.setAttribute("user", id);
		 return "redirect:/mypage/mypage";
	}
	
	
	
	
	@GetMapping("/mypage/mypage")
	public String mypage(HttpSession session, Model model) {
		String id = (String) session.getAttribute("user");
		boolean asd = id.length()<3;
		boolean Distinction = false;
		if(id.length()<3) {
		model.addAttribute("dto",professorDao.selectByPnum(id));
		
		}else {
		Distinction =true;
		model.addAttribute("dto",studentDao.selectBySnum(id));
		}
		session.setAttribute("Distinction", Distinction);
		model.addAttribute("Distinction",Distinction);
		return "mypage/mypage";
	}
	
	
	@GetMapping("/mypage/confirmpassword")
	public String confirmpassword() {
		return "mypage/confirmpassword";
	}
	
	@PostMapping("/mypage/confirmpassword")
	public String confirmpassword2(@RequestParam(value = "confirmpassword",defaultValue = "")String confirmpassword,
			HttpSession session, Model model) {
		String num = (String) session.getAttribute("password");
		log.info("-------------------"+num);
		if(confirmpassword.equals("")) {
			model.addAttribute("error","필수 입력란입니다.");
			return "mypage/confirmpassword";
		}

		if(num.equals(confirmpassword)) {
			return "redirect:/mypage/mypage2";
		}
		model.addAttribute("error","비밀번호가 잘못되었습니다.");
		return "mypage/confirmpassword";
	}
	@GetMapping("mypage/mypage2")
	public String updateUser(HttpSession session, Model model) {
		boolean dis = (boolean) session.getAttribute("Distinction");
		String id = (String) session.getAttribute("user");
		if(!dis) {
		model.addAttribute("dto",professorDao.selectByPnum(id));
		}else {
		model.addAttribute("dto",studentDao.selectBySnum(id));
		}
		model.addAttribute("dis",dis);
		return "mypage/mypage2";
	}
	
	@GetMapping("/mypage/updatepage")
	public String updateMypage(Student student,Professor professor,HttpSession session) {
		boolean dis = (boolean) session.getAttribute("Distinction");
		String id = (String) session.getAttribute("user");
		if(dis) {
			student.setSnum(id);
			log.info("============================"+student);
			studentDao.updateStudent(student);
		}else {
			professor.setPnum(id);
			log.info("============================"+professor);
			professorDao.updateProfessor(professor);
		}
		
		return "redirect:/mypage/mypage";
	}
	
	
	
	
}
