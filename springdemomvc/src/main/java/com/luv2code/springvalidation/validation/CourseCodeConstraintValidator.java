package com.luv2code.springvalidation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator 
			implements ConstraintValidator<CourseCode,String>{
	
	private String prefixCode;
	
	@Override
	public void initialize(CourseCode theCourseCode) {
		prefixCode = theCourseCode.value();
	}
	@Override
	public boolean isValid(String theCode,
			ConstraintValidatorContext theConstraintValidatorContext) {
		boolean result;
		if(theCode!=null) {
			result = theCode.startsWith(prefixCode);
		}else {
			return true;
		}
		return result;
	}

}
