package com.gamer.beans;

import java.util.List;

import javax.servlet.http.HttpSession;

public class PageOfProducts {

	private List<Product> products;
	private int pageNum;
	private int totalNumPages;
	
	public PageOfProducts() {
		super();
		products = null;
		pageNum = 0;
		totalNumPages = 0;
	}

	public List<Product> getProducts() {return products;}
	public void setProducts(List<Product> products, HttpSession session) {
		this.products = products;
		Basket basket = (Basket)session.getAttribute("basket");
		if (basket != null) {
			for (Product product : products) {
				product.setInBasket(basket.isInBasket(product.getId()));
			}
		}
	}

	public int getPageNum() {return pageNum;}
	public void setPageNum(int pageNum) {this.pageNum = pageNum;}

	public int getTotalNumPages() {return totalNumPages;}
	public void setTotalNumPages(int totalNumPages) {this.totalNumPages = totalNumPages;}
}
