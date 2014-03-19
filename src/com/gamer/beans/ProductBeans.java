package com.gamer.beans;

import java.util.ArrayList;
import java.util.List;

public class ProductBeans {
	
	private final int NUM_PROD_PER_PAGE = 9;

	private ArrayList<ProductBean> products = new ArrayList<>();
	
	public int getNumProductBeans() {return products.size();}
	
	public int getNumPagesToDisplay() {
		int numProds = getNumProductBeans();
		if (numProds % NUM_PROD_PER_PAGE == 0) {
			return numProds / NUM_PROD_PER_PAGE;
		}
		return (numProds / NUM_PROD_PER_PAGE) + 1;
	}
	
	public List<ProductBean> getProductBeansForPage(int pageNum) {
		int firstProduct = (pageNum - 1) * NUM_PROD_PER_PAGE;
		int lastProduct = firstProduct + 8;
		return products.subList(firstProduct, lastProduct);
	}
	
	public void addProductBean(ProductBean product) {
		products.add(product);
	}
}