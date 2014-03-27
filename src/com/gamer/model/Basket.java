package com.gamer.model;


public interface Basket {

	/**
	 * 
	 * @param productId
	 * @return returns false if no stock available.
	 */
	public boolean addOneToBasket(int productId);
	
	/**
	 * 
	 * @param productId
	 */
	public void removeOneFromBasket(int productId);
	
	/**
	 * 
	 * @param productId
	 */
	public void removeAllFromBasket(int productId);
	
	/**
	 * 
	 * @param productId
	 * @return
	 */
	public ProductInBasket getProductInBasket(int productId);
	
	/**
	 * 
	 * @return
	 */
	public ProductInBasket[] getAllProductsInBasket();
	
	/**
	 * 
	 * @return
	 */
	public int getTotalNumProductsInBasket();
	
	/**
	 * 
	 * @return
	 */
	public double getTotalCostOfBasket();
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean isInBasket(int id);
}
