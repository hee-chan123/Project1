package com.study.springboot.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.spring.SubjectDao;
import com.study.springboot.spring.SubjectGrade;
import com.study.springboot.spring.SubjectGradeDao;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class GradeController {

	@Autowired
	private SubjectDao subjectDao;
	
	@Autowired
	private SubjectGradeDao subjectgradeDao;
	
	@GetMapping("/modified")
	public String students(HttpSession session, Model model) {
		String pnum = (String) session.getAttribute("user");
		model.addAttribute("list",subjectDao.selectsPnum(pnum));
		return"/grade/students";
	}

	@GetMapping("/studentsview")
	public String studentsview(@RequestParam(value = "subnum",defaultValue = "")String subnum,HttpSession session, Model model) {
		
		if(subnum.equals("") || subnum == null) {
		subnum = (String) session.getAttribute("subnum");	
		}else {
			session.setAttribute("subnum", subnum);
		}
		
		
		model.addAttribute("list",subjectgradeDao.selectsSubnum(subnum));
		return"/grade/studentsview";
	}
	@GetMapping("/studentupdate")
	public String studentupdate(@RequestParam(value = "snum",defaultValue = "")String snum,HttpSession session, Model model) {
		String subnum = (String) session.getAttribute("subnum");
		
		model.addAttribute("dto",subjectgradeDao.selectBySubnum(subnum, snum));
		return"/grade/studentupdate";
	}
	
	@GetMapping("/update")
	public String update(HttpSession session, SubjectGrade subjectgrade,Model model) {
		String subnum = (String) session.getAttribute("subnum");
		subjectgrade.setSubnum(subnum);
		subjectgradeDao.updateStudent(subjectgrade);
		return"redirect:/studentsview";
	}
	
}
