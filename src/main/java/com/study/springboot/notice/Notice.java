package com.study.springboot.notice;

import java.time.LocalDateTime;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Notice {
	
	private long id;
	private String title;
	private String author;
	private LocalDateTime date;
	private String content;
	public Notice(String title, String author, LocalDateTime date, String content) {
		this.title = title;
		this.author = author;
		this.date = date;
		this.content = content;
	}
}
