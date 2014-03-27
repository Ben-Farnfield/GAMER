package com.gamer.model;

public class BasketLineUpdate {
	private int productId;
	private int stock;
	private int quantity;
	private int totalNumProductsInBasket;
	private double lineCost;
	private double totalCostOfBasket;
	
	public int getProductId() {return productId;}
	public void setProductId(int productId) {this.productId = productId;}
	
	public int getStock() {return stock;}
	public void setStock(int stock) {this.stock = stock;}
	
	public int getQuantity() {return quantity;}
	public void setQuantity(int quantity) {this.quantity = quantity;}
	
	public int getTotalNumProductsInBasket() {return totalNumProductsInBasket;}
	public void setTotalNumProductsInBasket(int totalNumProductsInBasket) {
		this.totalNumProductsInBasket = totalNumProductsInBasket;
	}
	
	public double getLineCost() {return lineCost;}
	public void setLineCost(double lineCost) {this.lineCost = lineCost;}
	
	public double getTotalCostOfBasket() {return totalCostOfBasket;}
	public void setTotalCostOfBasket(double totalCostOfBasket) {
		this.totalCostOfBasket = totalCostOfBasket;
	}
}
