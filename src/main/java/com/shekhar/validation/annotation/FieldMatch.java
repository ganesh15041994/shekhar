package com.shekhar.validation.annotation;

import static com.shekhar.domain.app.util.constants.ExceptionMessages.*;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.shekhar.data.validation.FieldMatcherValidation;

@Target({ TYPE, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = FieldMatcherValidation.class)
@Documented
public @interface FieldMatch {

	String messge() default THE_FILED_MUST_MATCH_EX_MSG;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

	String frist();

	String second();

	@Target({ TYPE, ANNOTATION_TYPE })
	@Retention(RUNTIME)
	@Documented
	@interface List {
		FieldMatch[] values();
	}

}
