package com.study.springboot.spring;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class SubjectGrade {
	private String subnum;
	private String snum;
	private int midtermGrade;
	private int finalGrade;
	private int attendanceDate;
	private String sname;
	private String grade;
	private String year;
	private String term;
}
