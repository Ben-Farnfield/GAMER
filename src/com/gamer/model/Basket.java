package com.gamer.model;

import java.util.HashMap;

import com.gamer.dao.DAOFactory;
import com.gamer.dao.ProductDAO;

public class Basket {
	
	private HashMap<Integer, ProductInBasket> basket = new HashMap<>();
	private int numProductsInBasket = 0;
	
	public Basket() { super(); }

	public void addOneToBasket(int productId) {
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
	}
	
	public void removeOneFromBasket(int productId) {
		if (basket.containsKey(productId)) {
			if (basket.get(productId).getQuantity() > 1) {
				basket.get(productId).removeOneProduct();
				numProductsInBasket--;
			}
		}
	}
	
	public void removeAllFromBasket(int productId) {
		if (basket.containsKey(productId)) {
			numProductsInBasket -= basket.get(productId).getQuantity();
			basket.remove(productId);
		}
	}
	
	public ProductInBasket getProductInBasket(int productId) {
		return basket.get(productId);
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
	
	public void updateStock() {
		ProductDAO dao = DAOFactory.getInstance().getProductDAO();
		int id;
		for (ProductInBasket product : basket.values()) {
			id = product.getProduct().getId();
			product.getProduct().setStock(dao.findProductStock(id));
		}
	}
	
	public boolean checkEnoughStock() {
		ProductDAO dao = DAOFactory.getInstance().getProductDAO();
		int id;
		for (ProductInBasket product : basket.values()) {
			id = product.getProduct().getId();
			if (product.getQuantity() > dao.findProductStock(id)) {
				return false;
			}
		}
		return true;
	}
	
	public void emptyBasket() {
		basket.clear();
		numProductsInBasket = 0;
	}
}
