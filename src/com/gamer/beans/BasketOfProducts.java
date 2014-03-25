package com.gamer.beans;

import java.util.HashMap;
import java.util.Map;

import com.gamer.data.dao.ProductDAO;

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
		ProductDAO dao = new ProductDAO();
		for (Map.Entry<Integer, Integer> item : itemsInBasket.entrySet()) {
			Product product = dao.getProduct(item.getKey());
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
