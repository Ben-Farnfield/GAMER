package com.gamer.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gamer.model.Customer;
import com.gamer.viewhelper.PurchaseViewHelper;
import com.gamer.viewhelper.ViewHelperFactory;

/**
 * 
 */
@WebServlet("/purchaseController")
public class PurchaseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PurchaseController() {super();}

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
		
		String url = "/";

		PurchaseViewHelper purchaseViewHelper =
				ViewHelperFactory.getInstance().getPurchaseViewHelper(req);
		
		Customer customer = (Customer) req.getSession().getAttribute("loggedInCustomer");

		if (purchaseViewHelper.checkEnoughFunds()) {

			if (purchaseViewHelper.checkEnoughStock()) {
				purchaseViewHelper.decreaseStock();
				purchaseViewHelper.decreaseCustomerBalance();
				purchaseViewHelper.emptyBasket();
				
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				Calendar cal = Calendar.getInstance();
				cal.setTime(new Date());
				cal.add(Calendar.DATE, 3);
				String deliveryDate = df.format(cal.getTime());
				
				req.setAttribute("msg", "" + customer.getForename() 
						+ ", your order has been successful. "
						+ "Your item(s) will be delivered by " + deliveryDate);
				req.setAttribute("link", "back to "
						+ "<a href=\"/GAMER/shop?action=home\">shopping</a>");
				url += "UserMsg.jsp";
			}
			else {
				purchaseViewHelper.updateBasketStock();
				url += "Basket.jsp";
			}
		}
		else {
			req.setAttribute("msg", "" + customer.getForename() 
					+ ", you don't currently have enough funds available to complete this purchase");
			req.setAttribute("link", "return to "
					+ "<a href=\"shop?action=basket\">basket</a>");
			url += "UserMsg.jsp";
		}
		getServletContext().getRequestDispatcher(url).forward(req, res);
	}
}
