package com.study.springboot.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;


@Repository
public class StudentDao {

//	private JdbcTemplate jdbcTemplate;
//
//	public MemberDao(DataSource dataSource) {
//		this.jdbcTemplate = new JdbcTemplate(dataSource);
//	}
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public StudentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	public void insertStudent(Student student) {
        String sql = "INSERT INTO student (snum, password, email, sname, phone, addr, grade, status, major) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
                student.getSnum(),
                student.getPassword(),
                student.getEmail(),
                student.getSname(),
                student.getPhone(),
                student.getAddr(),
                student.getGrade(),
                student.getStatus(),
                student.getMajor());
    }
	public Student selectBySnum(String snum) {
		List<Student> results = jdbcTemplate.query(
				"select * from Student where SNUM = ?", 
				new RowMapper<Student>() {
					@Override
					public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
						Student student = new Student(
								rs.getString("SNUM"),
			                    rs.getString("PASSWORD"),
			                    rs.getString("EMAIL"),
			                    rs.getString("SNAME"),
			                    rs.getString("PHONE"),
			                    rs.getString("ADDR"),
			                    rs.getString("GRADE"),
			                    rs.getString("STATUS"),
			                    rs.getString("MAJOR"));
						//student.setId(rs.getLong("ID"));
						return student;
					}
				}, snum);

		return results.isEmpty() ? null : results.get(0);
	}
	
	
	
//	public MemberDao(final DataSource dataSource) {
//	    this.jdbcTemplate = new JdbcTemplate(dataSource);
//	}
	
//	private RowMapper<Student> memRowMapper = (rs, n) -> {
//		Student student = new Student(
//				rs.getInt ("snum"),
//				rs.getString("PASSWORD"),
//				rs.getString("email"),
//				rs.getString("sname"),
//				rs.getString("phone"),
//				rs.getInt("grade")
//				
//				rs.getString("st")
//		Student.setId(rs.getLong("ID"));
//		return student;
//	};
//
//	
//
//	public void insert(Student student) {
//		KeyHolder keyHolder = new GeneratedKeyHolder();
//		jdbcTemplate.update(new PreparedStatementCreator() {
//			@Override
//			public PreparedStatement createPreparedStatement(Connection con)
//					throws SQLException {
//				// 파라미터로 전달받은 Connection을 이용해서 PreparedStatement 생성
//				PreparedStatement pstmt = con.prepareStatement(
//						"insert into MEMBER (EMAIL, PASSWORD, NAME, REGDATE) " +
//						"values (?, ?, ?, ?)",
//						new String[] { "ID" });
//				// 인덱스 파라미터 값 설정
//				pstmt.setString(1, member.getEmail());
//				pstmt.setString(2, member.getPassword());
//				pstmt.setString(3, member.getName());
//				pstmt.setTimestamp(4,
//						Timestamp.valueOf(member.getRegisterDateTime()));
//				// 생성한 PreparedStatement 객체 리턴
//				return pstmt;
//			}
//		}, keyHolder);
//		Number keyValue = keyHolder.getKey();
//		member.setId(keyValue.longValue());
//	}

	
	
	

	public int count() {
		Integer count = jdbcTemplate.queryForObject(
				"select count(*) from MEMBER", Integer.class);
		return count;
	}

	public static String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int updateStudent(Student student) { // 개인정보 수정
		String sql = "UPDATE Student SET sname = ?,addr = ?, phone = ?, email = ?, grade= ? ,status= ? ,major=?  WHERE snum = ?";
		return this.jdbcTemplate.update(sql,student.getSname(),student.getAddr(),student.getPhone(),
				student.getEmail(),student.getGrade(),student.getStatus(),student.getMajor(),student.getSnum());
	}

}