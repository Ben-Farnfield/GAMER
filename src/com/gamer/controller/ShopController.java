package com.gamer.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 */
@WebServlet(value="/shop")
public class ShopController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopController() { super(); }

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
		
		String action = (String)req.getParameter("action");
		if (action == null) action = "";
		
		String url = "/";
		
		switch (action) {
			
		case "login":
			url += "Login.jsp";
			break;
			
		case "register":
			url += "Register.jsp";
			break;
			
		case "basket":
			url += "basketServlet";
			break;
			
		case "games":
		case "toys":
		default:
			url += "productDisplay";
			break;
		}
		getServletContext().getRequestDispatcher(url).forward(req, res);
	}
}
