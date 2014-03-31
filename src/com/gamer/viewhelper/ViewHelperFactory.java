package com.gamer.viewhelper;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

public class ViewHelperFactory {

	private static ViewHelperFactory viewHelperFactory;
	
	private ViewHelperFactory() {}
	
	public static synchronized ViewHelperFactory getInstance() {
		if (viewHelperFactory == null) {
			viewHelperFactory = new ViewHelperFactory();
		}
		return viewHelperFactory;
	}
	
	public RegisterViewHelper getRegisterViewHelper(HttpServletRequest req) 
			throws UnsupportedEncodingException {
		RegisterViewHelper registerViewHelper = new RegisterViewHelper();
		registerViewHelper.setForename(new String(req.getParameter("forename")
				.getBytes("iso-8859-1"), "UTF-8"));
		registerViewHelper.setSurname(new String(req.getParameter("surname")
				.getBytes("iso-8859-1"), "UTF-8"));
		registerViewHelper.setEmail(new String(req.getParameter("email")
				.getBytes("iso-8859-1"), "UTF-8"));
		registerViewHelper.setPassword(new String(req.getParameter("password")
				.getBytes("iso-8859-1"), "UTF-8"));
		registerViewHelper.setConfPassword(new String(req.getParameter("conf-password")
				.getBytes("iso-8859-1"), "UTF-8"));
		registerViewHelper.setCardNum(new String(req.getParameter("card-num")
				.getBytes("iso-8859-1"), "UTF-8"));
		registerViewHelper.setHouseNum(new String(req.getParameter("house-num")
				.getBytes("iso-8859-1"), "UTF-8"));
		registerViewHelper.setStreet(new String(req.getParameter("street")
				.getBytes("iso-8859-1"), "UTF-8"));
		registerViewHelper.setPostcode(new String(req.getParameter("postcode")
				.getBytes("iso-8859-1"), "UTF-8"));
		return registerViewHelper;
	}
}
