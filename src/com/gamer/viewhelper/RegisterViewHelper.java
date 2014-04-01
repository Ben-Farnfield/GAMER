package com.gamer.viewhelper;

import com.gamer.dao.DAOFactory;
import com.gamer.model.Customer;
import com.gamer.util.UserInputUtil;

public class RegisterViewHelper {
	
	private static final String FORENAME_ERROR_MSG = 
			"forename can only contain letters";
	private static final String SURNAME_ERROR_MSG =
			"surname can only contain letters and the characters ' - . and space";
	private static final String HOUSE_NUM_ERROR_MSG = 
			"house number can only contain numbers";
	private static final String STREET_ERROR_MSG = 
			"street name can only contain letters";
	private static final String POSTCODE_ERROR_MSG = 
			"post code should be in the format AA9 9AA";
	private static final String EMAIL_ERROR_MSG = 
			"email must be in the format name@domain.com";
	private static final String EMAIL_PREV_USED_ERROR_MSG =
			"this email address has already been registered";
	private static final String CARD_NUM_ERROR_MSG = 
			"card number can only contain numbers and must be 16 digits";
	private static final String PASSWORD_ERROR_MSG =
			"passwords need to be between 6 and 16 characters";
	private static final String CONF_PASSWORD_ERROR_MSG = 
			"password and confirmation password don't match";

	private String forename;
	private String surname;
	private String houseNum;
	private String street;
	private String postcode;
	private String email;
	private String cardNum;
	private String password;
	private String confPassword;
	
	RegisterViewHelper() {super();}
	
	public void setForename(String forename) {this.forename = forename;}
	public String getForename() {return forename;}
	public String getForenameErrorMsg() {return FORENAME_ERROR_MSG;}
	public boolean isValidForename() {
		return UserInputUtil.isValidForename(forename);
	}
	
	public void setSurname(String surname) {this.surname = surname;}
	public String getSurname() {return surname;}
	public String getSurnameErrorMsg() {return SURNAME_ERROR_MSG;}
	public boolean isValidSurname() {
		return UserInputUtil.isValidSurname(surname);
	}
	
	public void setHouseNum(String houseNum) {this.houseNum = houseNum;}
	public String getHouseNum() {return houseNum;}
	public String getHouseNumErrorMsg() {return HOUSE_NUM_ERROR_MSG;}
	public boolean isValidHouseNum() {
		return UserInputUtil.isValidHouseNum(houseNum);
	}
	
	public void setStreet(String street) {this.street = street;}
	public String getStreet() {return street;}
	public String getStreetErrorMsg() {return STREET_ERROR_MSG;}
	public boolean isValidStreet() {
		return UserInputUtil.isValidStreet(street);
	}
	
	public void setPostcode(String postcode) {this.postcode = postcode;}
	public String getPostcode() {return postcode;}
	public String getPostcodeErrorMsg() {return POSTCODE_ERROR_MSG;}
	public boolean isValidPostcode() {
		return UserInputUtil.isValidPostcode(postcode);
	}
	
	public void setEmail(String email) {this.email = email;}
	public String getEmail() {return email;}
	public String getEmailErrorMsg() {return EMAIL_ERROR_MSG;}
	public boolean isValidEmail() {
		return UserInputUtil.isValidEmail(email);
	}
	public String getEmailPrevUsedErrorMsg() {return EMAIL_PREV_USED_ERROR_MSG;}
	public boolean isEmailInDatabase() {
		return DAOFactory.getInstance().getCustomerDAO().isEmailInDatabase(email);
	}
	
	public void setCardNum(String cardNum) {this.cardNum = cardNum;}
	public String getCardNum() {return cardNum;}
	public String getCardNumErrorMsg() {return CARD_NUM_ERROR_MSG;}
	public boolean isValidCardNum() {
		return UserInputUtil.isValidCardNum(cardNum);
	}
	
	public void setPassword(String password) {this.password = password;}
	public String getPassword() {return password;}
	public String getPasswordErrorMsg() {return PASSWORD_ERROR_MSG;}
	public boolean isValidPassword() {
		return UserInputUtil.isValidPassword(password);
	}
	
	public void setConfPassword(String confPassword) {this.confPassword = confPassword;}
	public String getConfPassword() {return confPassword;}
	public String getConfPasswordErrorMsg() {return CONF_PASSWORD_ERROR_MSG;}
	public boolean isMatchForPassword() {
		return UserInputUtil.isMatchForPassword(password, confPassword);
	}
	
	public boolean containsValidCustomerDetails() {
		return isValidForename()
				&& isValidSurname()
				&& isValidHouseNum()
				&& isValidStreet()
				&& isValidPostcode()
				&& isValidEmail()
				&& isValidCardNum()
				&& isValidPassword()
				&& isMatchForPassword();
	}
	
	public Customer createCustomer() {
		Customer customer = new Customer();
		customer.setForename(UserInputUtil.formatForename(forename));
		customer.setSurname(UserInputUtil.formatSurname(surname));
		customer.setEmail(UserInputUtil.formatEmail(email));
		customer.setPassword(UserInputUtil.formatPassword(password));
		customer.setCardNum(Long.parseLong(UserInputUtil.formatCardNum(cardNum)));
		customer.setHouseNo(Integer.parseInt(UserInputUtil.formatHouseNum(houseNum)));
		customer.setStreet(UserInputUtil.formatStreet(street));
		customer.setPostCode(UserInputUtil.formatPostcode(postcode));
		return customer;
	}
}
