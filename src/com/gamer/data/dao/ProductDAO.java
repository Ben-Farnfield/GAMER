package com.gamer.data.dao;

import java.util.ArrayList;

import com.gamer.beans.ProductBean;

public class ProductDAO {

	public ArrayList<ProductBean> getProductsForPage(int pageNum) {
		ArrayList<ProductBean> products = new ArrayList<>();
		
		String name;
		double price;
		String desc;
		String genre;
		String picUrl;
		int quantity;
		
		if (pageNum == 1) {
			name = "Call of Duty 2";
			price = 35;
			desc = "This is a description";
			genre = "FPS";
			picUrl = "/GAMER/res/img/pics/games/COD_2.png";
			quantity = 5;
		} else if (pageNum == 2) {
			name = "COD Black Ops 2";
			price = 25;
			desc = "This is a description";
			genre = "FPS";
			picUrl = "/GAMER/res/img/pics/games/COD_black_ops_2.png";
			quantity = 10;
		} else if (pageNum == 3) {
			name = "Dayz";
			price = 35;
			desc = "This is a description";
			genre = "RPG";
			picUrl = "/GAMER/res/img/pics/games/dayz.png";
			quantity = 5;
		} else {
			return new ArrayList<ProductBean>();
		}
		
		for (int i=0; i<9; i++) {
			ProductBean product = new ProductBean();
			product.setName(name);
			product.setPrice(price);
			product.setDescription(desc);
			product.setGenre(genre);
			product.setPictureURI(picUrl);
			product.setQuantity(quantity);
			products.add(product);
		}
		
		return products;
	}
	
	public ArrayList<ProductBean> getGamesForPage(int pageNum) {
		ArrayList<ProductBean> products = new ArrayList<>();
		
		String name;
		double price;
		String desc;
		String genre;
		String picUrl;
		int quantity;
		
		if (pageNum == 1) {
			name = "Battlefield 3";
			price = 35;
			desc = "This is a description";
			genre = "FPS";
			picUrl = "/GAMER/res/img/pics/games/BC_3.png";
			quantity = 5;
		} else if (pageNum == 2) {
			name = "Crysis 2";
			price = 25;
			desc = "This is a description";
			genre = "FPS";
			picUrl = "/GAMER/res/img/pics/games/crysis_2.png";
			quantity = 10;
		} else {
			name = "Mass Effect 3";
			price = 35;
			desc = "This is a description";
			genre = "RPG";
			picUrl = "/GAMER/res/img/pics/games/mass_effect_3.png";
			quantity = 5;
		}
		
		for (int i=0; i<9; i++) {
			ProductBean product = new ProductBean();
			product.setName(name);
			product.setPrice(price);
			product.setDescription(desc);
			product.setGenre(genre);
			product.setPictureURI(picUrl);
			product.setQuantity(quantity);
			products.add(product);
		}
		
		return products;
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
