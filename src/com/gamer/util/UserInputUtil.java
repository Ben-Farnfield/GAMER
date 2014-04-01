package com.gamer.util;


public class UserInputUtil {
	
	private UserInputUtil() {}
	
	// FORENAME
	public static boolean isValidForename(String forename) {
		if (forename == null) return false;
		return forename.matches("[a-zA-Z]+") && forename.length() <= 32;
	}

	public static String formatForename(String forename) {
		return capFirstLetter(forename);
	}
	
	// SURNAME
	public static boolean isValidSurname(String surname) {
		if (surname == null) return false;
		return surname.matches("[a-zA-Z][a-zA-Z ,'.-]+")
				 && surname.length() <= 32;
	}

	public static String formatSurname(String surname) {
		return capFirstLetter(surname);
	}
	
	// HOUSE NUM
	public static boolean isValidHouseNum(String houseNum) {
		if (houseNum == null) return false;
		return houseNum.matches("\\d+")  && houseNum.length() <= 4;
	}
	
	public static String formatHouseNum(String houseNum) {
		return houseNum.trim();
	}
	
	// STREET
	public static boolean isValidStreet(String street) {
		if (street == null) return false;
		return street.matches("[a-zA-Z ]+")  && street.length() <= 32;
	}
	
	public static String formatStreet(String street) {
		return capFirstLetter(street);
	}
	
	// POSTCODE
	public static boolean isValidPostcode(String postcode) {
		if (postcode == null) return false;
		return postcode.matches("[a-zA-Z]{2}\\d{1,2}\\s*\\d{1,2}[a-zA-Z]{2}")
				 && postcode.length() <= 10;
	}
	
	public static String formatPostcode(String postcode) {
		postcode = postcode.trim();
		return postcode.toUpperCase();
	}
	
	// EMAIL
	public static boolean isValidEmail(String email) {
		if (email == null) return false;
		return email.matches("[\\w-_.]+@[\\w-.]+\\.[a-zA-Z]{2,4}")
				 && email.length() <= 100;
	}
	
	public static String formatEmail(String email) {
		email = email.trim();
		return email.toLowerCase();
	}
	
	// CARD NUM
	public static boolean isValidCardNum(String cardNum) {
		if (cardNum == null) return false;
		return cardNum.matches("\\d{16}")  && cardNum.length() <= 16;
	}
	
	public static String formatCardNum(String cardNum) {
		return cardNum.trim();
	}
	
	// PASSWORD
	public static boolean isValidPassword(String password) {
		if (password == null) return false;
		return password.length() >= 6 && password.length() <= 16;
	}
	
	public static boolean isMatchForPassword(String password, String confPassword) {
		if (password == null || confPassword == null) return false;
		return password.equals(confPassword);
	}
	
	public static String formatPassword(String password) {
		// DO NOTHING
		return password;
	}
	
	private static String capFirstLetter(String field) {
		field = field.trim().toLowerCase();
		return field.substring(0, 1).toUpperCase() + field.substring(1);
	}
}
