package com.gamer.dao;

import com.gamer.model.Customer;

public interface CustomerDAO {

	public boolean isEmailInDatabase(String email);
	
	public boolean emailPasswordComboIsInDatabase(String email, String password);
	
	public Customer findCustomerByEmail(String email);
	
	public double findCustomersBalance(int id);
	
	public void insertCustomer(Customer customer);
}