package com.study.springboot.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.springboot.spring.DuplicateStudentException;
import com.study.springboot.spring.Student;
import com.study.springboot.spring.StudentDao;

import lombok.Setter;

@Service
public class StudentRegisterService {
	@Autowired
	private StudentDao studentDao;

	public StudentRegisterService(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	
	
	@Transactional
	public String regist(RegisterRequest req) {
		Student student = studentDao.selectBySnum(req.getSnum());
		if (student != null) {
			throw new DuplicateStudentException("dup snum " + req.getSnum());
		}
		Student newStudent = new Student(
			            req.getSnum(), req.getPassword(), req.getEmail(), req.getSname(), 
			            req.getPhone(), req.getAddr(), req.getGrade(), req.getStatus(), req.getMajor());
		studentDao.insertStudent(newStudent);
		return StudentDao.getId();
	}
}
