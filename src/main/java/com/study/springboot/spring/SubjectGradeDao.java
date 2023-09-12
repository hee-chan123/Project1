package com.study.springboot.spring;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SubjectGradeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
//	public List<SubjectGrade> selectAll(String snum){ //특정학생의 성적정보
//		String sql = "select * from subjectgrade where snum = ? order by year desc, subnum desc";
//		List<SubjectGrade> list = jdbcTemplate.query(sql, (rs, r) -> {
//			SubjectGrade subGrade = new SubjectGrade(
//					rs.getString("subnum"),
//					rs.getString("snum"),
//					rs.getInt("midtermGrade"),
//					rs.getInt("finalGrade"),
//					rs.getInt("attendanceDate"),
//					rs.getString("sname"),
//					rs.getString("grade"),
//					rs.getString("year"),
//					rs.getString("term"));
//			return subGrade;
//		}, snum);
//		return list.isEmpty() ? null : list;
//	}
	
	public List<SubjectGrade> selectsSubnum(String subnum) {//학번으로 성적가져오기
		String sql = "select * from subjectgrade where subnum = ?";
		List<SubjectGrade> results = jdbcTemplate.query(sql,(rs, r) -> {
					SubjectGrade subjectgrade = new SubjectGrade(
							rs.getString("subnum"),
							rs.getString("snum"),
							rs.getInt("midtermgrade"),
							rs.getInt("finalgrade"),
							rs.getInt("Attendancedate"),
							rs.getString("sname"),
							rs.getString("grade"),
							rs.getString("year"),
							rs.getString("term"));
					return subjectgrade;
				},subnum);
		return results;
	}
	
	public SubjectGrade selectBySubnum(String subnum,String snum) {//학번으로 성적가져오기
		String sql = "select * from subjectgrade where subnum = ? and snum = ?";
		List<SubjectGrade> results = jdbcTemplate.query(sql,(rs, r) -> {
					SubjectGrade subjectgrade = new SubjectGrade(
							rs.getString("subnum"),
							rs.getString("snum"),
							rs.getInt("midtermgrade"),
							rs.getInt("finalgrade"),
							rs.getInt("Attendancedate"),
							rs.getString("sname"),
							rs.getString("grade"),
							rs.getString("year"),
							rs.getString("term"));
					return subjectgrade;
				},subnum,snum);
		return results.isEmpty() ? null : results.get(0);
	}
	
	public List<SubjectGrade> selectGrade(String snum, String year, String term){ //특정학생의 해당연도, 해당 학기의 성적정보
		String sql = "select * from subjectgrade where snum = ? and year = ? and term = ?";
		List<SubjectGrade> list = jdbcTemplate.query(sql, (rs, r) -> {
			SubjectGrade grade = new SubjectGrade(
					rs.getString("subnum"),
					rs.getString("snum"),
					rs.getInt("midtermGrade"),
					rs.getInt("finalGrade"),
					rs.getInt("attendanceDate"),
					rs.getString("sname"),
					rs.getString("grade"),
					rs.getString("year"),
					rs.getString("term"));
			return grade;
		}, snum, year, term);
		return list;
	}
	
	public int countSub(String snum, String year, String term) { //과목수
		String sql = "select count(*) from subjectgrade where snum = ? and year = ? and term = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, snum, year, term);
	}
	
	public int sumCredit(String snum, String year, String term) { //총 학점
		String sql = "select sum(credit)"
				+ "from subject "
				+ "where subnum in (select subnum"
				+ "				from subjectgrade"
				+ "				where snum = ? and year = ? and term = ?)";
		return jdbcTemplate.queryForObject(sql, Integer.class, snum, year, term);
	}
	
	public int getCredit(String snum, String year, String term) { //취득학점
		String sql = "select sum(credit)"
				+ "from subject "
				+ "where subnum in (select subnum"
				+ "				from subjectgrade"
				+ "				where snum = ? and year = ? and term = ? and grade in('A', 'B', 'C', 'D'))";
		return jdbcTemplate.queryForObject(sql, Integer.class, snum, year, term);
	}
	
	public List<String> getProName(String snum, String year, String term) { //교수이름
		String sql = "select pname "
				+ "from professor "
				+ "where pnum in "
				+ "(select pnum from subject where subnum in (select subnum from subjectgrade where snum = ? and year = ? and term = ?))";
		return jdbcTemplate.query(sql, (rs, r) -> {
			String proName = rs.getString("pname");
			return proName;
		}, snum, year, term);
	}
	
	public List<String> getSubName(String snum, String year, String term) { //과목이름
		String sql = "select subname from subject where subnum in (select subnum from subjectgrade where snum = ? and year = ? and term = ?)";
		return jdbcTemplate.query(sql, (rs, r) -> {
			String subName = rs.getString("subname");
			return subName;
		}, snum, year, term);
	}
	
	public int maxYear(String snum) { //학생이 강의를 들은 max 연도
		String sql = "select max(year) from subjectgrade where snum = ?";
		return Integer.parseInt(jdbcTemplate.queryForObject(sql, String.class, snum));
	}
	
	public int minYear(String snum) { //학생이 강의를 들은 min 연도
		String sql = "select min(year) from subjectgrade where snum = ?";
		return Integer.parseInt(jdbcTemplate.queryForObject(sql, String.class, snum));
	}
	
	public int countTerm(String snum, String year) { //해당연도의 학기 수
		String sql = "SELECT count(distinct term) FROM subjectgrade where snum = ? and year = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, snum, year);
	}
	
	public int countG(String snum, String year, String term) { // 특정학생의 해당연도 해당학기에 들은 강의 수
		String sql = "select count(*) from subjectgrade where snum = ? and year = ? and term = ?";
		return jdbcTemplate.queryForObject(sql, Integer.class, snum, year, term);
	}
	
	public int updateStudent(SubjectGrade subjectgrade) { // 개인정보 수정
		String sql = "UPDATE subjectgrade SET midtermgrade = ?, finalgrade = ?, Attendancedate = ?, grade = ? WHERE snum = ? and subnum = ?";
		return this.jdbcTemplate.update(sql,subjectgrade.getMidtermGrade(),subjectgrade.getFinalGrade(),subjectgrade.getAttendanceDate()
				,subjectgrade.getGrade(),subjectgrade.getSnum(),subjectgrade.getSubnum());
	}
}
