package com.study.springboot.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GradeCommand {

	private String year;
	private String term;
	private int sub;
	private int sumCredit;
	private int getCredit;
}
