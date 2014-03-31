package com.gamer.model;

public class Customer {

	private int id;
	private String forename;
	private String surname;
	private int houseNum;
	private String street;
	private String postCode;
	private String email;
	private double balance;
	private long cardNum;
	private String password;
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public String getForename() {return forename;}
	public void setForename(String forename) {this.forename = forename;}
	
	public String getSurname() {return surname;}
	public void setSurname(String surname) {this.surname = surname;}
	
	public int getHouseNo() {return houseNum;}
	public void setHouseNo(int houseNum) {this.houseNum = houseNum;}
	
	public String getStreet() {return street;}
	public void setStreet(String street) {this.street = street;}
	
	public String getPostCode() {return postCode;}
	public void setPostCode(String postCode) {this.postCode = postCode;}
	
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	
	public double getBalance() {return balance;}
	public void setBalance(double balance) {this.balance = balance;}
	
	public long getCardNum() {return cardNum;}
	public void setCardNum(long cardNum) {this.cardNum = cardNum;}
	
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
}
