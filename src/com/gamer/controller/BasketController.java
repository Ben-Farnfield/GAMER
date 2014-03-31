package com.gamer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gamer.model.Basket;
import com.gamer.model.BasketImpl;
import com.gamer.model.BasketLineUpdate;
import com.gamer.model.ProductInBasket;
import com.google.gson.Gson;

/**
 * 
 */
@WebServlet("/basketController")
public class BasketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasketController() { super(); }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest req, HttpServletResponse res)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		doPost(req, res);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest req, HttpServletResponse res)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		HttpSession session = req.getSession(true);
		
		String action = (String)req.getParameter("action");
		if (action == null) action = "";
		
		String id = req.getParameter("id");
		
		Basket basket = (Basket)session.getAttribute("basket");
		if (basket == null) {
			basket = new BasketImpl();
			session.setAttribute("basket", basket);
		}
		
		switch (action) {
		case "basket":
			session.setAttribute(
					"allProductsInBasket", basket.getAllProductsInBasket());
			getServletContext().getRequestDispatcher("/Basket.jsp").forward(req, res);
			break;
		
		case "add-to-basket":
			if (id != null) {
				basket.addOneToBasket(Integer.parseInt(id));

				ProductInBasket prodInBasket = 
						basket.getProductInBasket(Integer.parseInt(id));
				
				String json = buildBasketLineUpdateJson(basket, prodInBasket);
				
				res.setContentType("application/json");
			    res.setCharacterEncoding("UTF-8");
			    res.getWriter().write(json);
			}
			break;

		case "rem-from-basket":
			if (id != null) {
				
				ProductInBasket prodInBasket = basket.getProductInBasket(Integer.parseInt(id));
				
				basket.removeOneFromBasket(Integer.parseInt(id));

				// TODO fix this so you no longer get null
				if (basket.getProductInBasket(Integer.parseInt(id)) != null) {
					prodInBasket = basket.getProductInBasket(Integer.parseInt(id));
				} else {
					prodInBasket.setQuantity(0);
				}
				
				String json = buildBasketLineUpdateJson(basket, prodInBasket);
				
				res.setContentType("application/json");
			    res.setCharacterEncoding("UTF-8");
			    res.getWriter().write(json);
			}
			break;
			
		case "del-from-basket":
			if (id != null) {
				basket.removeAllFromBasket(Integer.parseInt(id));
				
				String json = "{\"totalNumProductsInBasket\":"+ basket.getTotalNumProductsInBasket() +", "
						+ "\"totalCostOfBasket\":"+ basket.getTotalCostOfBasket() +"}";
				
				res.setContentType("application/json");
			    res.setCharacterEncoding("UTF-8");
			    res.getWriter().write(json);
			}
			break;
		}
	}
	
	private String buildBasketLineUpdateJson(
			Basket basket, ProductInBasket prodInBasket) {
		
		BasketLineUpdate baskUpdate = new BasketLineUpdate();
		baskUpdate.setProductId(prodInBasket.getProduct().getId());
		baskUpdate.setQuantity(prodInBasket.getQuantity());
		baskUpdate.setLineCost(
				prodInBasket.getQuantity() * prodInBasket.getProduct().getPrice());
		baskUpdate.setStock(prodInBasket.getProduct().getStock());
		baskUpdate.setTotalCostOfBasket(basket.getTotalCostOfBasket());
		baskUpdate.setTotalNumProductsInBasket(basket.getTotalNumProductsInBasket());
		
		 return new Gson().toJson(baskUpdate);
	}
}
