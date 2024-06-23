package com.shekhar.domain.entities.binding;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.shekhar.domain.app.util.constants.ExceptionMessages;
import com.shekhar.validation.annotation.FieldMatch;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import static com.shekhar.domain.app.util.constants.ExceptionMessages.*;
import static com.shekhar.domain.app.util.constants.ValidationErrorMessages.*;
import static com.shekhar.domain.app.util.constants.AppConstants.*;

@Setter
@Getter
@NoArgsConstructor
@ToString

@FieldMatch(frist = "password", second = "confirmPassword", messge = "The Password Filed Must Match")
public class UserRegisterBindingModel {

	@NotNull(message = INCOREECT_USERNAME)
	@NotEmpty(message = INCORRECT_USERNAME_EMPTY_FIELD_MESSAGE)
	@Size(min = USERNAME_MIN_LENGTH, max = USERNAME_MAX_LENGTH)
	private String username;

	@NotNull
	@Size(min = PASSWORD_MIN_LENGTH, message = ExceptionMessages.INCORRECT_PASSWORD)
	private String password;
	
	private String confirmPassword;
	
	@NotNull
	@Size(min=5 , message = INCORRECT_ADDRESS)
	private String address;
	
	@NotNull()
	@Email(regexp = VALID_EMAIL_ADDRESS_REGEX,message = INCORRECT_EMAIL)
	private String email;

}
