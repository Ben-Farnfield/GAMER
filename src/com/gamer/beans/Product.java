package com.gamer.beans;

import java.io.Serializable;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String genre;
	private String description;
	private String pictureURI;
	private double price;
	private int quantity;
	private int id;
	private boolean isInBasket;
	
	public Product() {super();}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getGenre() {return genre;}
	public void setGenre(String genre) {this.genre = genre;}

	public String getDescription() {return description;}
	public void setDescription(String description) {this.description = description;}

	public String getPictureURI() {return pictureURI;}
	public void setPictureURI(String picURI) {this.pictureURI = picURI;}

	public double getPrice() {return price;}
	public void setPrice(double price) {this.price = price;}

	public int getQuantity() {return quantity;}
	public void setQuantity(int quantity) {this.quantity = quantity;}
	
	public int getId() {return id;}
	public void setId(int id) {this.id = id;}

	public boolean isInBasket() {return isInBasket;}
	public void setInBasket(boolean isInBasket) {this.isInBasket = isInBasket;}
}
