package com.shekhar.domain.app.util.constants;

public final class ExceptionMessages {

	private ExceptionMessages() {
	}

	
	// for name filed validation massages
	public static final String INCOREECT_USERNAME = "Username should be between  3 to 20 symbol";
	public static final String INCORRECT_USERNAME_EMPTY_FIELD_MESSAGE = "Cannot empty , at least have 3 Symbol";
	public static final String INCORRECT_PASSWORD ="password must contain 3 letter ";
	public static final String INCORRECT_ADDRESS="cannot be a empty should have 5 letters";
    public static final String INCORRECT_EMAIL = "Email should be valid, compliant with RFC822.";


	
	// for Filed Matcher Annotation 
	public static final String THE_FILED_MUST_MATCH_EX_MSG="this field must Match";

}
