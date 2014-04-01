package com.gamer.viewhelper;

import com.gamer.dao.DAOFactory;
import com.gamer.model.Basket;
import com.gamer.model.Customer;

public class PurchaseViewHelper {
	
	private Customer customer;
	private Basket basket;
	
	public Customer getCustomer() {return customer;}
	public void setCustomer(Customer customer) {this.customer = customer;}
	
	public Basket getBasket() {return basket;}
	public void setBasket(Basket basket) {this.basket = basket;}
	
	public boolean customerHasSufficientFunds() {
		
		double customersBalance = DAOFactory.getInstance().getCustomerDAO()
				.findCustomersBalance(customer.getId());
		double costOfBasket = basket.getTotalCostOfBasket();
		
		return customersBalance > costOfBasket;
	}
}
