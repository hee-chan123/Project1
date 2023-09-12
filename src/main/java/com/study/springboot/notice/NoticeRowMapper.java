package com.study.springboot.notice;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class NoticeRowMapper implements RowMapper<Notice>{

	@Override
	public Notice mapRow(ResultSet rs, int rowNum) throws SQLException {
		Notice notice = new Notice(
				rs.getString("TITLE"),
				rs.getString("AUTHOR"),
				rs.getTimestamp("DATE").toLocalDateTime(),
				rs.getString("CONTENT")
				);
		notice.setId(rs.getLong("ID"));
		return notice;
	}

}
