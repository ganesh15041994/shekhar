package com.shekhar.data.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.beanutils.BeanUtils;

import com.shekhar.validation.annotation.FieldMatch;

public class FieldMatcherValidation implements ConstraintValidator<FieldMatch, Object> {

	private String fristFieldName;
	private String secondFieldName;
	private String message;

	@Override
	public void initialize(final FieldMatch constraintAnnotation) {
		// TODO Auto-generated method stub

		fristFieldName = constraintAnnotation.frist();
		secondFieldName = constraintAnnotation.second();
		message = constraintAnnotation.messge();

		ConstraintValidator.super.initialize(constraintAnnotation);
	}

	@Override
	public boolean isValid(Object value, final ConstraintValidatorContext context) {

		boolean valid = true;
		try {
			final Object fistObj = BeanUtils.getProperty(value, fristFieldName);
			final Object secObj = BeanUtils.getProperty(value, secondFieldName);

			valid = fistObj == null && secObj == null || fistObj != null && fistObj.equals(secObj);
		}

		catch (final Exception ignore) {
			// ignore if Exception Occure
		}

		if (!valid) {
			context.buildConstraintViolationWithTemplate(message).addPropertyNode(fristFieldName)
					.addConstraintViolation().disableDefaultConstraintViolation();
		}
		return valid;
	}

}
