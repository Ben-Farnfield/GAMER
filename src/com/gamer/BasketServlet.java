package com.gamer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gamer.beans.Basket;
import com.gamer.beans.BasketOfProducts;

/**
 * 
 */
@WebServlet("/basketServlet")
public class BasketServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasketServlet() { super(); }

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
			basket = new Basket();
			session.setAttribute("basket", basket);
		}
		
		switch (action) {
		case "basket":
			BasketOfProducts basketOfProducts = new BasketOfProducts();
			basketOfProducts.setItemsInBasket(basket.getItemsInBasket());
			session.setAttribute("basketOfProducts", basketOfProducts);
			getServletContext().getRequestDispatcher("/Basket.jsp").forward(req, res);
			break;
		
		case "add_to_basket":
			if (id != null) {
				basket.addToBasket(Integer.parseInt(id));
				res.setContentType("text/plain");
				res.setCharacterEncoding("UTF-8");
				res.getWriter().print(basket.getNumItemsInBasket());	
			}
			break;

		case "rem_from_basket":
			if (id != null) {
				basket.removeFromBasket(Integer.parseInt(id));
				res.setContentType("text/plain");
				res.setCharacterEncoding("UTF-8");
				res.getWriter().print(basket.getNumItemsInBasket());	
			}
			break;
			
		case "del_from_basket":
			if (id != null) {
				basket.deleteFromBasket(Integer.parseInt(id));
				res.setContentType("text/plain");
				res.setCharacterEncoding("UTF-8");
				res.getWriter().print(basket.getNumItemsInBasket());	
			}
			break;
		}
	}
}
