package com.gamer.model;

import java.util.HashMap;
import java.util.Map;

import com.gamer.dao.DAOFactory;
import com.gamer.dao.ProductDAO;

public class BasketOfProducts {

	private HashMap<Product, Integer> productsInBasket;
	private double totalCostOfBasket;
	
	public BasketOfProducts() { 
		super();
		productsInBasket = new HashMap<>();
	}

	public HashMap<Product, Integer> getProductsInBasket() {
		return productsInBasket;
	}
	
	public void setItemsInBasket(HashMap<Integer, Integer> itemsInBasket) {
		ProductDAO dao = DAOFactory.getInstance().getProductDAO();
		for (Map.Entry<Integer, Integer> item : itemsInBasket.entrySet()) {
			Product product = dao.findProduct(item.getKey());
			productsInBasket.put(product, item.getValue());
		}
	}
	
	public double getTotalCostOfBasket() {
		totalCostOfBasket = 0;
		for (Map.Entry<Product, Integer> product : productsInBasket.entrySet()) {
			totalCostOfBasket += product.getKey().getPrice() * product.getValue();
		}
		return totalCostOfBasket;
	}
}
