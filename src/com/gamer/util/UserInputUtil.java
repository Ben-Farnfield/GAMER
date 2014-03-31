package com.gamer.util;


public class UserInputUtil {
	
	private UserInputUtil() {}
	
	// FORENAME
	public static boolean isValidForename(String forename) {
		if (forename == null) return false;
		return forename.matches("[a-zA-Z]+");
	}

	public static String formatForename(String forename) {
		forename = forename.trim();
		forename = forename.toLowerCase();
		String firstLetter = forename.substring(0, 1).toUpperCase();
		return firstLetter + forename.substring(1);
	}
	
	// SURNAME
	public static boolean isValidSurname(String surname) {
		if (surname == null) return false;
		return surname.matches("(O'|o')?[a-zA-Z]+(-[a-zA-Z])?[a-zA-Z]*");
	}

	public static String formatSurname(String surname) {
		surname = surname.trim();
		surname = surname.toLowerCase();
		String firstLetter = surname.substring(0, 1).toUpperCase();
		if (surname.matches(".*-.*")) {
			int index = surname.indexOf("-");
			String secondFirstLetter = 
					surname.substring(index+1, index+2).toUpperCase();
			return firstLetter + surname.substring(1, index+1) 
					+ secondFirstLetter + surname.substring(index+2);
		}
		return firstLetter + surname.substring(1);
	}
	
	// HOUSE NUM
	public static boolean isValidHouseNum(String houseNum) {
		if (houseNum == null) return false;
		return houseNum.matches("\\d+");
	}
	
	public static String formatHouseNum(String houseNum) {
		return houseNum.trim();
	}
	
	// STREET
	public static boolean isValidStreet(String street) {
		if (street == null) return false;
		return street.matches("[a-zA-Z\\s]+");
	}
	
	public static String formatStreet(String street) {
		street = street.trim();
		street = street.toLowerCase();
		String firstLetter = street.substring(0, 1).toUpperCase();
		return firstLetter + street.substring(1);
	}
	
	// POSTCODE
	public static boolean isValidPostcode(String postcode) {
		if (postcode == null) return false;
		return postcode.matches("[a-zA-Z]{2}[0-9]{1,2}\\s[0-9]{1,2}[a-zA-Z]{2}");
	}
	
	public static String formatPostcode(String postcode) {
		postcode = postcode.trim();
		return postcode.toUpperCase();
	}
	
	// EMAIL
	public static boolean isValidEmail(String email) {
		if (email == null) return false;
		return email.matches("[\\w-_\\.]+@[\\w-_]+\\.[a-zA-Z]+");
	}
	
	public static String formatEmail(String email) {
		email = email.trim();
		return email.toLowerCase();
	}
	
	// CARD NUM
	public static boolean isValidCardNum(String cardNum) {
		if (cardNum == null) return false;
		return cardNum.matches("\\d+");
	}
	
	public static String formatCardNum(String cardNum) {
		return cardNum.trim();
	}
	
	// PASSWORD
	public static boolean isValidPassword(String password) {
		if (password == null) return false;
		return password.matches(".{6,16}");
	}
	
	public static boolean isMatchForPassword(String password, String confPassword) {
		if (password == null || confPassword == null) return false;
		return password.equals(confPassword);
	}
	
	public static String formatPassword(String password) {
		// DO NOTHING
		return password;
	}
}
