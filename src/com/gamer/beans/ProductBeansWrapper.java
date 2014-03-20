package com.gamer.beans;

import java.util.ArrayList;
import java.util.List;

public class ProductBeansWrapper {
	
	private final int NUM_PROD_PER_PAGE = 9;

	private ArrayList<ProductBean> products = new ArrayList<>();
	
	public int getNumProducts() {return products.size();}
	
	public int getNumPagesToDisplayProducts() {
		int numProds = getNumProducts();
		if (numProds % NUM_PROD_PER_PAGE == 0) {
			return numProds / NUM_PROD_PER_PAGE;
		}
		return (numProds / NUM_PROD_PER_PAGE) + 1;
	}
	
	public List<ProductBean> getProductsForPage(int pageNum) {
		int firstProduct = (pageNum - 1) * NUM_PROD_PER_PAGE;
		int lastProduct = firstProduct + NUM_PROD_PER_PAGE;
		try {
			return products.subList(firstProduct, lastProduct);
		} catch (IndexOutOfBoundsException e) {
			return products.subList(firstProduct, getNumProducts());
		}
	}
	
	public void addProduct(ProductBean product) {
		products.add(product);
	}
}
