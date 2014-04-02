package com.gamer.viewhelper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.gamer.model.Basket;
import com.gamer.model.Product;

public class ProductViewHelper {
	
	private static final int NUM_PROD_PER_PAGE = 9;

	private ArrayList<Product> products;
	private int currentPage;
	private String keyword;
	
	ProductViewHelper() {super();}
	
	public void setProducts(ArrayList<Product> products, Basket basket) {
		if (basket != null) {
			for (Product product : products) {
				product.setInBasket(basket.isInBasket(product.getId()));
			}
		}
		
		this.products = products;
		
		removeSoldOutProducts();
	}
	public ArrayList<Product> getProducts() {return products;}
	
	public void setCurrentPage(int currentPage) {this.currentPage = currentPage;}
	public int getCurrentPage() {return currentPage;}
	
	public String getKeyword() {return keyword;}
	public void setKeyword(String keyword) {this.keyword = keyword;}

	public int getTotalNumberOfPages() {
		
		int numProds = products.size();
		
		if (numProds % NUM_PROD_PER_PAGE == 0) {
			return numProds / NUM_PROD_PER_PAGE;
		}
		
		return (int) Math.floor(numProds / NUM_PROD_PER_PAGE) + 1;
	}
	
	public List<Product> getProductsForPage() {
		
		int firstProduct = (currentPage - 1) * NUM_PROD_PER_PAGE;
		int lastProduct = firstProduct + NUM_PROD_PER_PAGE;
		
		try {
			return products.subList(firstProduct, lastProduct);
		} catch (IndexOutOfBoundsException e) {
			return products.subList(firstProduct, products.size());
		}
	}
	
	private void removeSoldOutProducts() {
		Iterator<Product> iterator = products.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getStock() == 0) iterator.remove();
		}
	}
}
