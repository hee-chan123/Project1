package com.study.springboot.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.spring.Professor;
import com.study.springboot.spring.ProfessorDao;
import com.study.springboot.spring.WrongIdPasswordException;

@Service
public class AuthServiceP {

	@Autowired
	private ProfessorDao professorDao;

//	public void setMemberDao(MemberDao memberDao) {
//		this.memberDao = memberDao;
//	}

	public PAuthInfo authenticateP(String pnum, String password) {
		Professor professor = professorDao.selectByPnum(pnum);
		if (professor == null) {
			throw new WrongIdPasswordException();
		}
		if (!professor.matchPassword(password)) {
			throw new WrongIdPasswordException();
		}
		return new PAuthInfo(professor.getPnum(),professor.getEmail(),
				professor.getPassword());
	}

}
