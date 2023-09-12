package com.study.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.spring.SubjectGrade;
import com.study.springboot.spring.SubjectGradeDao;
import com.study.springboot.spring.TestDao;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MyController {
	
	@Autowired
	TestDao testDao;
	
	@Autowired
	SubjectGradeDao subjectGradeDao;
	
	@GetMapping("/main")
	public String main() {
//		log.info("------------------------------------");
		return "main";
	}

	@GetMapping("/test")
	public String t() {
//		log.info("", subjectGradeDao.selectGrade("20171111", "2017", "1"));
		return "test";
	}
	
//	@GetMapping("/test/gradeTest")
//	public String test(@ModelAttribute("subjectGrades") List<SubjectGrade> subjectGrades,
//			@RequestParam("sub")String sub,
//			@RequestParam("sumCredit")String sumCredit,
//			@RequestParam("getCredit")String getCredit,
//			@RequestParam("years") List<String> years,
//			@RequestParam("begin")int begin,
//			@RequestParam("end")int end,
//			@RequestParam("minYear")String minYear,
//			@RequestParam("tableCol")String tableCol) {
//		return "test/gradeTest";
//	}
//	
//	@PostMapping("/test/gradeTest")
//	public String test2(@RequestParam(value = "snum")String snum, Model model){
//		List<SubjectGrade> subjectGrades = subjectGradeDao.selectAll(snum);
//		int sub = subjectGradeDao.countSub(snum, "2018", "1");
//		int sumCredit = subjectGradeDao.sumCredit(snum, "2018", "1");
//		int getCredit = subjectGradeDao.getCredit(snum, "2018", "1");
//		List<String> years = subjectGradeDao.getYear(snum);
//		int maxYear = subjectGradeDao.maxYear(snum);
//		int minYear = subjectGradeDao.minYear(snum);
//		int begin = minYear-minYear;
//		int end = maxYear-minYear;
//		
//		model.addAttribute("subjectGrades", subjectGrades);
//		model.addAttribute("sub", sub);
//		model.addAttribute("sumCredit", sumCredit);
//		model.addAttribute("getCredit", getCredit);
//		model.addAttribute("years", years);	
//		model.addAttribute("begin", begin);
//		model.addAttribute("end", end);
//		return "test/gradeTest";
//	}
//	
//	// ****************************************************************************************
//	
//	@GetMapping("/test/ggrade")
//	public String grade(@RequestParam(value = "snum")String snum, Model model,
//						@RequestParam(value = "year")String year,
//						@RequestParam(value = "term")String term) {
//		List<SubjectGrade> grades = subjectGradeDao.selectGrade(snum, year, term);
//		List<String> proName = subjectGradeDao.getProName(snum, year, term);
//		List<String> subName = subjectGradeDao.getSubName(snum, year, term);
//		
//		model.addAttribute("grades", grades);
//		model.addAttribute("proName", proName);
//		model.addAttribute("subName", subName);
//		return "test/ggrade";
//	}
//	
//	@PostMapping("/test/ggrade")
//	public String grade2(@ModelAttribute("grades") List<SubjectGrade> grades) {
//		return "test/gradeTest";
//	}
}
