package com.gamer.dao;

import com.gamer.model.Customer;

public interface CustomerDAO {

	public boolean isEmailInDatabase(String email);
	
	public void insertCustomer(Customer customer);
}
