package com.gamer.viewhelper;

import com.gamer.dao.CustomerDAO;
import com.gamer.dao.DAOFactory;
import com.gamer.dao.ProductDAO;
import com.gamer.model.Basket;
import com.gamer.model.Customer;
import com.gamer.model.ProductInBasket;

public class PurchaseViewHelper {
	
	private Customer customer;
	private Basket basket;
	
	PurchaseViewHelper() {super();}
	
	public Customer getCustomer() {return customer;}
	public void setCustomer(Customer customer) {this.customer = customer;}
	
	public Basket getBasket() {return basket;}
	public void setBasket(Basket basket) {this.basket = basket;}
	
	public boolean checkEnoughFunds() {
		return customer.getBalance() >= basket.getTotalCostOfBasket();
	}
	
	public boolean checkEnoughStock() {
		return basket.checkEnoughStock();
	}
	
	public void updateBasketStock() {
		basket.updateStock();
	}
	
	public void decreaseStock() {
		ProductDAO dao = DAOFactory.getInstance().getProductDAO();
		int id;
		for (ProductInBasket product : basket.getAllProductsInBasket()) {
			id = product.getProduct().getId();
			dao.decreaseStock(id, basket.getProductInBasket(id).getQuantity());
		}
	}
	
	public void decreaseCustomerBalance() {
		CustomerDAO dao = DAOFactory.getInstance().getCustomerDAO();
		
		dao.decreaseBalance(customer.getId(), basket.getTotalCostOfBasket());
		customer.setBalance(dao.findCustomersBalance(customer.getId()));
	}
	
	public void emptyBasket() {
		basket.emptyBasket();
	}
}
