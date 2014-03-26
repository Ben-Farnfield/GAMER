package com.gamer.model;

import java.util.HashMap;

import com.gamer.dao.DAOFactory;
import com.gamer.dao.ProductDAO;

public class BasketImpl implements Basket {
	
	private HashMap<Integer, ProductInBasket> basket = new HashMap<>();
	private int numProductsInBasket = 0;
	
	public BasketImpl() { super(); }

	public boolean addOneToBasket(int productId) {
		boolean isAdded;
		if (basket.containsKey(productId)) {
			isAdded = basket.get(productId).addOneProduct();
		} else {
			ProductInBasket prod = new ProductInBasket();
			ProductDAO dao = DAOFactory.getInstance().getProductDAO();
			isAdded = prod.setProduct(dao.findProduct(productId));
			if (isAdded) basket.put(productId, prod);
		}
		if (isAdded) {
			numProductsInBasket++;
		}
		return isAdded;
	}
	
	public void removeOneFromBasket(int productId) {
		if (basket.containsKey(productId)) {
			if (basket.get(productId).getQuantity() > 1) {
				basket.get(productId).removeOneProduct();
			} else {
				basket.remove(productId);
			}
			numProductsInBasket--;
		}
	}
	
	public void removeAllFromBasket(int productId) {
		if (basket.containsKey(productId)) {
			numProductsInBasket -= basket.get(productId).getQuantity();
			basket.remove(productId);
		}
	}
	
	public ProductInBasket[] getAllProductsInBasket() {
		return basket.values().toArray(new ProductInBasket[0]);
	}
	
	public int getTotalNumProductsInBasket() {
		return numProductsInBasket;
	}
	
	public double getTotalCostOfBasket() {
		double cost = 0;
		ProductInBasket[] products = getAllProductsInBasket();
		for (ProductInBasket product : products) {
			cost += product.getQuantity() * product.getProduct().getPrice();
		}
		return cost;
	}
	
	public boolean isInBasket(int productId) {
		return basket.containsKey(productId);
	}
}
