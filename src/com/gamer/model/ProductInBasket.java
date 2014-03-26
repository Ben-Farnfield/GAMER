package com.gamer.model;

public class ProductInBasket {

	private Product product;
	private int quantity;
	
	public Product getProduct() { return product; }
	public boolean setProduct(Product product) {
		if (product.getStock() == 0) return false;
		this.product = product;
		quantity = 1;
		return true;
	}
	
	public int getQuantity() { return quantity; }
	
	public boolean addOneProduct() { 
		if (quantity < product.getStock()) {
			quantity++;
			return true;
		}
		return false;
	}
	
	public void removeOneProduct() { 
		if (quantity > 0) quantity--;
	}
}
