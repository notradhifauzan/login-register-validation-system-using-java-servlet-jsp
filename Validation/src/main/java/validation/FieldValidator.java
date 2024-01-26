package validation;

import java.util.regex.*; 

public class FieldValidator {
	
	/*
	 * username invalid if:
	 * 1. contains space
	 * 2. too short (at least 5 characters)
	 * 3. no small letter at all
	 * 4. no capital letter at all
	 * 5. no number at all
	 * 
	 * */
	
	private static final String USERNAME_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?!.*\\s).{4,}$";
	private static final Pattern patternUsername = Pattern.compile(USERNAME_PATTERN);
	
	/*
	 * password invalid if:
	 * 1. no lowercase letter
	 * 2. no uppercase letter
	 * 3. no digit
	 * 4. no special character
	 * 5. length is less than 8 characters
	 * 
	 */
	
	private static final String PASSWORD_PATTERN = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";
	private static final Pattern patternPassword = Pattern.compile(PASSWORD_PATTERN);

	public static boolean validateUsername(String username) {
		return patternUsername.matcher(username).matches();
	}
	
	public static boolean validatePassword(String password) {
		return patternPassword.matcher(password).matches();
	}
}
