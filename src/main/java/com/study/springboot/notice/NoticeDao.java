package com.study.springboot.notice;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public NoticeDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public Notice SelectById(long id) {
		List<Notice> results = jdbcTemplate.query(
				"select * from NOTICE where ID = ?", 
				new NoticeRowMapper(), id);
		return results.isEmpty() ? null : results.get(0);
	}
	
	public void insert(Notice notice) {
		String sql = "INSERT INTO notice (title, author, date, content)"
				+ "VALUES (?, ?, now(), ?)";
		jdbcTemplate.update(sql, notice.getTitle(), notice.getAuthor(), notice.getContent());
	}
	
	public void update(Notice notice) {
		String sql = "UPDATE notice SET title=?, author=?, date = now(), content=? where id=?";
		jdbcTemplate.update(sql, notice.getTitle(), notice.getAuthor(), notice.getContent(), notice.getId());
	}
	
	public void delete(long id) {
		String sql = "DELETE FROM notice WHERE id = ?";
		jdbcTemplate.update(sql, id);
	}
	
	public List<Notice> selectAll() {
		List<Notice> results = jdbcTemplate.query("select * from NOTICE", new NoticeRowMapper());
		return results;
	}
	
	public int count() { //전체 행 개수를 구하는 코드
		Integer count = jdbcTemplate.queryForObject("select count(*) from Notice", Integer.class);
		return count;
	}
}
