package com.gamer.data.dao;

import java.util.ArrayList;

import com.gamer.beans.ProductBean;
import com.gamer.beans.ProductBeans;

public class ProductDAO {

	public ProductBeans getProducts() {
		ProductBeans productBeans = new ProductBeans();
		
		String name = "Call of Duty 2";
		double price = 35;
		String desc = "This is a description";
		String genre = "FPS";
		String picUrl = "/GAMER/res/img/pics/games/COD_2.png";
		int quantity  = 5;

		for (int i=0; i<12; i++) {
			ProductBean product = new ProductBean();
			product.setName(name);
			product.setPrice(price);
			product.setDescription(desc);
			product.setGenre(genre);
			product.setPictureURI(picUrl);
			product.setQuantity(quantity);
			productBeans.addProduct(product);
		}
		
		name = "COD Black Ops 2";
		price = 25;
		desc = "This is a description";
		genre = "FPS";
		picUrl = "/GAMER/res/img/pics/games/COD_black_ops_2.png";
		quantity = 10;
		
		for (int i=0; i<12; i++) {
			ProductBean product = new ProductBean();
			product.setName(name);
			product.setPrice(price);
			product.setDescription(desc);
			product.setGenre(genre);
			product.setPictureURI(picUrl);
			product.setQuantity(quantity);
			productBeans.addProduct(product);
		}
		
		name = "Dayz";
		price = 35;
		desc = "This is a description";
		genre = "RPG";
		picUrl = "/GAMER/res/img/pics/games/dayz.png";
		quantity = 5;
		
		for (int i=0; i<12; i++) {
			ProductBean product = new ProductBean();
			product.setName(name);
			product.setPrice(price);
			product.setDescription(desc);
			product.setGenre(genre);
			product.setPictureURI(picUrl);
			product.setQuantity(quantity);
			productBeans.addProduct(product);
		}
		
		return productBeans;
	}
	
	public ProductBeans getGames() {
		ProductBeans productBeans = new ProductBeans();
		
		String name = "Battlefield 3";
		double price = 35;
		String desc = "This is a description";
		String genre = "FPS";
		String picUrl = "/GAMER/res/img/pics/games/BC_3.png";
		int quantity = 5;
		
		for (int i=0; i<9; i++) {
			ProductBean product = new ProductBean();
			product.setName(name);
			product.setPrice(price);
			product.setDescription(desc);
			product.setGenre(genre);
			product.setPictureURI(picUrl);
			product.setQuantity(quantity);
			productBeans.addProduct(product);
		}

		name = "Crysis 2";
		price = 25;
		desc = "This is a description";
		genre = "FPS";
		picUrl = "/GAMER/res/img/pics/games/crysis_2.png";
		quantity = 10;
		
		for (int i=0; i<9; i++) {
			ProductBean product = new ProductBean();
			product.setName(name);
			product.setPrice(price);
			product.setDescription(desc);
			product.setGenre(genre);
			product.setPictureURI(picUrl);
			product.setQuantity(quantity);
			productBeans.addProduct(product);
		}
		
		name = "Mass Effect 3";
		price = 35;
		desc = "This is a description";
		genre = "RPG";
		picUrl = "/GAMER/res/img/pics/games/mass_effect_3.png";
		quantity = 5;
		
		for (int i=0; i<9; i++) {
			ProductBean product = new ProductBean();
			product.setName(name);
			product.setPrice(price);
			product.setDescription(desc);
			product.setGenre(genre);
			product.setPictureURI(picUrl);
			product.setQuantity(quantity);
			productBeans.addProduct(product);
		}
		
		return productBeans;
	}
	
	public ArrayList<ProductBean> getToysForPage(int pageNum) {
		ArrayList<ProductBean> products = new ArrayList<>();
		
		return products;
	}
	
	public ArrayList<ProductBean> getSearchResult(String[] keywords) {
		ArrayList<ProductBean> products = new ArrayList<>();
		
		return products;
	}
}
