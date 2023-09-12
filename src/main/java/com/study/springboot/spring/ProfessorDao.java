package com.study.springboot.spring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;



@Repository
public class ProfessorDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ProfessorDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
	
	public void insertProfessor(Professor professor) {
        String sql = "INSERT INTO student (pnum, password, email, pname, phone, addr, major) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql,
        		professor.getPnum(),
        		professor.getPassword(),
        		professor.getEmail(),
        		professor.getPname(),
        		professor.getPhone(),
                professor.getAddr(),
                professor.getMajor());
    }
	public Professor selectByPnum(String pnum) {
		List<Professor> results = jdbcTemplate.query(
				"select * from Professor where PNUM = ?", 
				
				new RowMapper<Professor>() {
					@Override
					public Professor mapRow(ResultSet rs, int rowNum) throws SQLException {
						Professor professor = new Professor(
								rs.getString("PNUM"),
			                    rs.getString("PASSWORD"),
			                    rs.getString("EMAIL"),
			                    rs.getString("PNAME"),
			                    rs.getString("PHONE"),
			                    rs.getString("ADDR"),
			                    rs.getString("MAJOR")
								);
						
						//student.setId(rs.getLong("ID"));
						return professor;
					}
				}, pnum);

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

	
		public void updateProfessor(Professor professor) { // 개인정보 수정
			String sql = "UPDATE Professor SET pname = ?,addr = ?, phone = ?, email = ?, major = ?  WHERE pnum = ?";
			this.jdbcTemplate.update(sql,professor.getPname(),professor.getAddr(),professor.getPhone(),
					professor.getEmail(),professor.getMajor(),professor.getPnum());
		}

	

	public int count() {
		Integer count = jdbcTemplate.queryForObject(
				"select count(*) from Professor", Integer.class);
		return count;
	}

	public static String getId() {
		// TODO Auto-generated method stub
		return null;
	}
	


}