package com.gamer.beans;

public class ProductBean {
	
	private String name;
	private String genre;
	private String desc;
	private String picURI;
	private double price;
	private int quantity;
	
	public ProductBean() {super();}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}

	public String getGenre() {return genre;}
	public void setGenre(String genre) {this.genre = genre;}

	public String getDescription() {return desc;}
	public void setDescription(String desc) {this.desc = desc;}

	public String getPictureURI() {return picURI;}
	public void setPictureURI(String picURI) {this.picURI = picURI;}

	public double getPrice() {return price;}
	public void setPrice(double price) {this.price = price;}

	public int getQuantity() {return quantity;}
	public void setQuantity(int quantity) {this.quantity = quantity;}
}
