package com.gamer.viewhelper;

import com.gamer.dao.DAOFactory;
import com.gamer.util.UserInputUtil;

public class LoginViewHelper {
	
	private static final String EMAIL_ERROR_MSG = 
			"email must be in the format name@domain.com";
	private static final String PASSWORD_ERROR_MSG =
			"passwords need to be between 6 and 16 characters";
	private static final String PASSWORD_NOT_FOUND_ERROR = 
			"username and password not found, please enter valid login details";
	
	private String email;
	private String password;

	LoginViewHelper() {super();}
	
	public void setEmail(String email) {this.email = email;}
	public String getEmail() {return email;}
	public String getEmailErrorMsg() {return EMAIL_ERROR_MSG;}
	public boolean isValidEmail() {
		return UserInputUtil.isValidEmail(email);
	}
	
	public void setPassword(String password) {this.password = password;}
	public String getPassword() {return password;}
	public String getPasswordErrorMsg() {return PASSWORD_ERROR_MSG;}
	public boolean isValidPassword() {
		return UserInputUtil.isValidPassword(password);
	}
	public String getPasswordNotFoundErrorMsg() {return PASSWORD_NOT_FOUND_ERROR;}
	public boolean emailPasswordComboIsInDatabase() {
		return DAOFactory.getInstance().getCustomerDAO()
				.emailPasswordComboIsInDatabase(email, password);
	}
	
	public boolean containsValidLoginDetails() {
		return isValidPassword() && isValidEmail();
	}
}
