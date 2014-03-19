package com.gamer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gamer.beans.ProductBean;
import com.gamer.data.dao.ProductDAO;

/**
 * 
 */
@WebServlet(value="/shop")
public class ControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlServlet() {super();}

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
		
		String page = (String)req.getParameter("page");
		if (page == null) page = "";
		
		int pageNum;
		try {
			pageNum = Integer.parseInt(req.getParameter("n"));
		} catch (NumberFormatException e) {
			pageNum = 1;
		}
				
		ProductDAO dao = new ProductDAO();
		ArrayList<ProductBean> products = new ArrayList<>();
		
		String url = "/";
		
		switch (page) {

		case "games":
			products = dao.getGamesForPage(pageNum);
			url += "Games.jsp?n=" + pageNum;
			break;
		case "toys":
			
			break;
		case "basket":
			
			break;
		default:
			products = dao.getProductsForPage(pageNum);
			url += "Home.jsp?n=" + pageNum;
			break;
		}
		session.setAttribute("gamer.products", products);
		session.setAttribute("gamer.n", pageNum);
		getServletContext().getRequestDispatcher(url).forward(req, res);
	}
}
