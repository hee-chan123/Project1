package com.study.springboot.controller;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PLoginCommandValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PLoginCommand.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pnum", "required");
		ValidationUtils.rejectIfEmpty(errors, "password", "required");
	}

}
