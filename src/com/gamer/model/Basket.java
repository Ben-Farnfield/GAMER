package com.gamer.model;

import java.io.Serializable;
import java.util.HashMap;

public class Basket implements Serializable {
	private static final long serialVersionUID = 1L;
	
	// <product ID, number of product added>
	private HashMap<Integer, Integer> itemsInBasket = new HashMap<>();
	private int numItemsInBasket = 0;
	
	public Basket() {
		super();
	}

	public void addToBasket(int productId) {
		if (itemsInBasket.containsKey(productId)) {
			itemsInBasket.put(productId, itemsInBasket.get(productId) + 1);
		} else {
			itemsInBasket.put(productId, 1);
		}
		numItemsInBasket++;
	}
	
	public void removeFromBasket(int productId) {
		if (itemsInBasket.containsKey(productId)) {
			if (itemsInBasket.get(productId) > 1) {
				itemsInBasket.put(productId, itemsInBasket.get(productId) - 1);
			} else {
				itemsInBasket.remove(productId);
			}
			numItemsInBasket--;
		}
	}
	
	public void deleteFromBasket(int productId) {
		if (itemsInBasket.containsKey(productId)) {
			int numItems = itemsInBasket.get(productId);
			itemsInBasket.remove(productId);
			numItemsInBasket -= numItems;
		}
	}
	
	public HashMap<Integer, Integer> getItemsInBasket() {
		return itemsInBasket;
	}
	
	public int getNumItemsInBasket() {
		return numItemsInBasket;
	}
	
	public boolean isInBasket(int productId) {
		return itemsInBasket.containsKey(productId);
	}
}
