package com.gamer.data.dao;

import java.util.ArrayList;

import com.gamer.beans.Product;

public class ProductDAO {

	public ArrayList<Product> getProducts() {
		ArrayList<Product> products = new ArrayList<>();
		
		String name = "Call of Duty 2";
		double price = 35;
		String desc = "This is a description";
		String genre = "FPS";
		String picUrl = "/GAMER/res/img/pics/games/COD_2.png";
		int quantity  = 5;
		int id = 100;

		for (int i=0; i<13; i++) {
			Product product = new Product();
			product.setName(name);
			product.setPrice(price);
			product.setDescription(desc);
			product.setGenre(genre);
			product.setPictureURI(picUrl);
			product.setQuantity(quantity);
			product.setId(id + i);
			products.add(product);
		}
		
		name = "COD Black Ops 2";
		price = 25;
		desc = "This is a description";
		genre = "FPS";
		picUrl = "/GAMER/res/img/pics/games/COD_black_ops_2.png";
		quantity = 10;
		id = 200;
		
		for (int i=0; i<13; i++) {
			Product product = new Product();
			product.setName(name);
			product.setPrice(price);
			product.setDescription(desc);
			product.setGenre(genre);
			product.setPictureURI(picUrl);
			product.setQuantity(quantity);
			product.setId(id + i);
			products.add(product);
		}
		
		name = "Dayz";
		price = 35;
		desc = "This is a description";
		genre = "RPG";
		picUrl = "/GAMER/res/img/pics/games/dayz.png";
		quantity = 5;
		id = 300;
		
		for (int i=0; i<13; i++) {
			Product product = new Product();
			product.setName(name);
			product.setPrice(price);
			product.setDescription(desc);
			product.setGenre(genre);
			product.setPictureURI(picUrl);
			product.setQuantity(quantity);
			product.setId(id + i);
			products.add(product);
		}
		
		return products;
	}
	
	public Product getProduct(int id) {
		Product product = new Product();
		
		String name = "Call of Duty 2";
		double price = 35;
		String desc = "This is a description";
		String genre = "FPS";
		String picUrl = "/GAMER/res/img/pics/games/COD_2.png";
		int quantity  = 5;
		
		product.setName(name);
		product.setPrice(price);
		product.setDescription(desc);
		product.setGenre(genre);
		product.setPictureURI(picUrl);
		product.setQuantity(quantity);
		product.setId(id);
		
		return product;
	}
	
	public ArrayList<Product> getGames() {
		ArrayList<Product> products = new ArrayList<>();
		
		String name = "Battlefield 3";
		double price = 35;
		String desc = "This is a description";
		String genre = "FPS";
		String picUrl = "/GAMER/res/img/pics/games/BC_3.png";
		int quantity = 5;
		int id = 400;
		
		for (int i=0; i<9; i++) {
			Product product = new Product();
			product.setName(name);
			product.setPrice(price);
			product.setDescription(desc);
			product.setGenre(genre);
			product.setPictureURI(picUrl);
			product.setQuantity(quantity);
			product.setId(id + i);
			products.add(product);
		}

		name = "Crysis 2";
		price = 25;
		desc = "This is a description";
		genre = "FPS";
		picUrl = "/GAMER/res/img/pics/games/crysis_2.png";
		quantity = 10;
		id = 500;
		
		for (int i=0; i<9; i++) {
			Product product = new Product();
			product.setName(name);
			product.setPrice(price);
			product.setDescription(desc);
			product.setGenre(genre);
			product.setPictureURI(picUrl);
			product.setQuantity(quantity);
			product.setId(id + i);
			products.add(product);
		}
		
		name = "Mass Effect 3";
		price = 35;
		desc = "This is a description";
		genre = "RPG";
		picUrl = "/GAMER/res/img/pics/games/mass_effect_3.png";
		quantity = 5;
		id = 600;
		
		for (int i=0; i<9; i++) {
			Product product = new Product();
			product.setName(name);
			product.setPrice(price);
			product.setDescription(desc);
			product.setGenre(genre);
			product.setPictureURI(picUrl);
			product.setQuantity(quantity);
			product.setId(id + i);
			products.add(product);
		}
		
		return products;
	}
	
	public ArrayList<Product> getToys() {		
		return new ArrayList<>();
	}
	
	public ArrayList<Product> getSearchResults(String[] keywords) {
		return new ArrayList<>();
	}
}
