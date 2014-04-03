package com.gamer.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class PurchaseFilter implements Filter {

    public PurchaseFilter() {}
    public void init(FilterConfig fConfig) throws ServletException {}
	public void destroy() {}

	public void doFilter(ServletRequest req, ServletResponse res, 
			FilterChain chain) throws IOException, ServletException {
		
		String url = "/";
		
		HttpServletRequest request = (HttpServletRequest)req;
		HttpSession session = request.getSession(true);

		if ("purchase".equals(request.getParameter("action"))) {
			
			if (session.getAttribute("loggedInCustomer") != null) { // user logged in
				url += "purchaseController";
			}
			else {
				req.setAttribute("requestAction", "purchase");
				url += "Login.jsp";
			}
			request.getRequestDispatcher(url).forward(req, res);
		}
		else {
			chain.doFilter(req, res);
		}
	}
}
