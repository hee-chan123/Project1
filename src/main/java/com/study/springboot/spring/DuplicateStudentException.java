package com.study.springboot.spring;

public class DuplicateStudentException extends RuntimeException {
public DuplicateStudentException(String message) {
	super(message);
}
}
