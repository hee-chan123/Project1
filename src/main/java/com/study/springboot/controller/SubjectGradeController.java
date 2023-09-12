package com.study.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.study.springboot.spring.SubjectGrade;
import com.study.springboot.spring.SubjectGradeDao;

import lombok.extern.slf4j.Slf4j;

@Controller
public class SubjectGradeController {

	@Autowired
	SubjectGradeDao subjectGradeDao;
	
	@GetMapping("/credit/sumGrade")
	public String test(HttpSession session, Model model) {
		String snum = (String) session.getAttribute("user");
		List<GradeCommand> gradeCommands = new ArrayList<>();
		int maxYear = subjectGradeDao.maxYear(snum);
		int minYear = subjectGradeDao.minYear(snum);
		
		for(int i = maxYear; i >= minYear; i--) {
			int countTerm = subjectGradeDao.countTerm(snum, i+"");
			for(int j = countTerm; j >= 1; j--) {
				int p = 0;
				
				if(j == 1 && subjectGradeDao.countG(snum,i+"",countTerm+"")==0) {
					p++;
				}
				
				int sub = subjectGradeDao.countSub(snum, i+"", j+p+"");
				int sumCredit = subjectGradeDao.sumCredit(snum, i+"", j+p+"");
				int getCredit = subjectGradeDao.getCredit(snum, i+"", j+p+"");
				gradeCommands.add(new GradeCommand(""+i, j+p+"", sub, sumCredit, getCredit));
			}
		}
		
		model.addAttribute("snum", snum);
		model.addAttribute("gradeCommands", gradeCommands);
		return "credit/sumGrade";
	}

//	@PostMapping("/credit/sumGrade")//@RequestParam("snum") String snum @ModelAttribute("gradeCommand") List<GradeCommand> gradeCommand, 
//	public String test2(Model model, HttpSession session){
//		String snum = (String) session.getAttribute("user");
//		List<GradeCommand> gradeCommands = new ArrayList<>();
//		int maxYear = subjectGradeDao.maxYear(snum);
//		int minYear = subjectGradeDao.minYear(snum);
//		
//		for(int i = maxYear; i >= minYear; i--) {
//			int countTerm = subjectGradeDao.countTerm(snum, i+"");
//			for(int j = countTerm; j >= 1; j--) {
//				int sub = subjectGradeDao.countSub(snum, i+"", j+"");
//				int sumCredit = subjectGradeDao.sumCredit(snum, i+"", j+"");
//				int getCredit = subjectGradeDao.getCredit(snum, i+"", j+"");
//				gradeCommands.add(new GradeCommand(""+i, j+"", sub, sumCredit, getCredit));
//			}
//		}
//		
//		model.addAttribute("snum", snum);
//		model.addAttribute("gradeCommands", gradeCommands);
//		return "credit/sumGrade";
//	}
	
	// ****************************************************************************************
	
	@GetMapping("/credit/grade")
	public String grade(@RequestParam("snum")String snum, Model model,
						@RequestParam("year")String year,
						@RequestParam("term")String term) {
		List<SubjectGrade> grades = subjectGradeDao.selectGrade(snum, year, term);
		List<NamesCommand> names = new ArrayList<>();
		List<String> pname = subjectGradeDao.getProName(snum, year, term);
		List<String> sname = subjectGradeDao.getSubName(snum, year, term);		
		int countG = subjectGradeDao.countG(snum, year, term);
		
		
		for(int i = 1; i <= countG; i++) {
			names.add(new NamesCommand(pname.get(i-1), sname.get(i-1)));
		}
		
		model.addAttribute("grades", grades);
		model.addAttribute("names", names);
		
		
		return "credit/grade";
	}
	
//	@PostMapping("/test/ggrade")
//	public String grade2(@ModelAttribute("grades") List<SubjectGrade> grades,
//						 @ModelAttribute("names") List<GradeCommand> names) {
//		return "test/gradeTest";
//	}
}
