package com.gamer.dao;

import java.util.ArrayList;

import com.gamer.model.Product;

public interface ProductDAO {
	
	public ArrayList<Product> findAllProducts();
	
	public ArrayList<Product> findAllGames();
	
	public ArrayList<Product> findAllToys();
	
	public Product findProduct(int id);
	
	public int findProductStock(int id);
	
	public ArrayList<Product> searchByKeywords(String[] keywords);
	
	public void decreaseStock(int id, int amount);
}
