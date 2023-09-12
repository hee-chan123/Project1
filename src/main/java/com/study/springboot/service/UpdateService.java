package com.study.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.spring.Professor;
import com.study.springboot.spring.ProfessorDao;


public class UpdateService {


	private ProfessorDao professorDao;
	
	public UpdateService(String pnum, Professor professor) {
		professor.setPnum(pnum);
		professorDao.updateProfessor(professor);
	}
	
	
	
}
