package com.study.springboot.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.spring.Student;
import com.study.springboot.spring.StudentDao;
import com.study.springboot.spring.WrongIdPasswordException;

@Service
public class AuthService {

	@Autowired
	private StudentDao studentDao;

//	public void setMemberDao(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}

	public AuthInfo authenticate(String snum, String password) {
		Student student = studentDao.selectBySnum(snum);
		if (student == null) {
			throw new WrongIdPasswordException();
		}
		if (!student.matchPassword(password)) {
			throw new WrongIdPasswordException();
		}
		return new AuthInfo(student.getSnum(),student.getEmail(),
				student.getPassword());
	}

}
