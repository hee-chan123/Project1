package com.study.springboot.spring;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class SubjectDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Subject> selectsPnum(String pnum) {//학번으로 성적가져오기
		List<Subject> results = jdbcTemplate.query("select * from subject where pnum = ?",
				(ResultSet rs, int rowNum) -> {
					Subject subject = new Subject(
							rs.getString("subnum"),
							rs.getString("subname"),
							rs.getString("pnum"),
							rs.getString("credit"));
					return subject;
				},pnum);
		return results;
	}
//	public int updateStudent(Student student) { // 개인정보 수정
//		String sql = "UPDATE Student SET sname = ?,addr = ?, phone = ?, email = ?, grade= ? ,status= ? ,major=?  WHERE snum = ?";
//		return this.jdbcTemplate.update(sql,student.getSname(),student.getAddr(),student.getPhone(),
//				student.getEmail(),student.getGrade(),student.getStatus(),student.getMajor(),student.getSnum());
//	}
	
	
	
}
