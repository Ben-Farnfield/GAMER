package com.gamer.viewhelper;

import com.gamer.model.Basket;
import com.gamer.model.ProductInBasket;

public class BasketViewHelper {

	private Basket basket;
	private int id;
	
	BasketViewHelper() {super();}
	
	public Basket getBasket() {return basket;}
	public void setBasket(Basket basket) {this.basket = basket;}

	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
	
	public boolean basketIsEmpty() {
		return basket.getTotalNumProductsInBasket() == 0;
	}

	public String addOneToBasket() {
		basket.addOneToBasket(id);
		return buildUpdateJson();
	}
	
	public String removeOneFromBasket() {
		basket.removeOneFromBasket(id);
		return buildUpdateJson();
	}
	
	public String removeAllFromBasket() {
		basket.removeAllFromBasket(id);
		return 
		"{\"totalNumProductsInBasket\":" + basket.getTotalNumProductsInBasket()
		+ ",\"totalCostOfBasket\":" + basket.getTotalCostOfBasket() + "}";
	}

	private String buildUpdateJson() {
		
		ProductInBasket productInBasket = basket.getProductInBasket(id);
		
		return 
		"{\"productId\":1" + productInBasket.getProduct().getId()
		+ ",\"stock\":" + productInBasket.getProduct().getStock()
		+ ",\"quantity\":" + productInBasket.getQuantity()
		+ ",\"totalNumProductsInBasket\":" + basket.getTotalNumProductsInBasket()
		+ ",\"lineCost\":" + productInBasket.getQuantity() 
							* productInBasket.getProduct().getPrice()
		+ ",\"totalCostOfBasket\":" + basket.getTotalCostOfBasket() + "}";
	}
}
