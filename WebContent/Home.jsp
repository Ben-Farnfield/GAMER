<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList, com.gamer.beans.ProductBean" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>GAMER.com</title>
<link rel="stylesheet" type="text/css" href="/GAMER/res/css/Theme.css">
<link rel="stylesheet" type="text/css" href="/GAMER/res/css/TopBar.css">
<link rel="stylesheet" type="text/css" href="/GAMER/res/css/Header.css">
<link rel="stylesheet" type="text/css" href="/GAMER/res/css/Nav.css">
<link rel="stylesheet" type="text/css" href="/GAMER/res/css/Content.css">
<link rel="stylesheet" type="text/css" href="/GAMER/res/css/Footer.css">
<link rel="stylesheet" type="text/css" href="/GAMER/res/css/Product.css">
</head>
<body class="home">
<jsp:include page="/res/template/TopBar.jsp" flush="true"/>
<jsp:include page="/res/template/Header.jsp" flush="true"/>
<jsp:include page="/res/template/Nav.jsp" flush="true"/>
<div id="content">
<%
@SuppressWarnings("unchecked")
ArrayList<ProductBean> products = 
	(ArrayList<ProductBean>)session.getAttribute("gamer.products");
if (products == null) {
	response.sendRedirect("/GAMER/shop?page=home");
} else {
	int pageNum;
	try {
		pageNum = Integer.parseInt(request.getParameter("n"));
	} catch (NumberFormatException e) {
		pageNum = 1;
	}
	System.out.println(pageNum);
	for (ProductBean product : products) {
%>
<div class="prod">
<img src="<%= product.getPictureURI() %>" alt="<%= product.getName() %>">						
<h2>£ <%= product.getPrice() %> : <%= product.getName() %></h2>
<p>
<em>Genre: <%= product.getGenre() %></em>
<br/>
<br/>
<%= product.getDescription() %>	
</p>
<input type="submit" value="Add to Basket" />
</div>
<%		
	} // for (Product product : products) {
	
	if (pageNum == 1 && products.size() == 9) {
%>
<form>
<input type="hidden" name="page" value="home"/>
<input type="hidden" name="n" value="<%= pageNum+1 %>"/>	
<input type="submit" value="next page >"/>
</form>
<%		
	} else if (pageNum > 1 && products.size() == 9) {
%>
<form>
<input type="hidden" name="page" value="home"/>
<input type="hidden" name="n" value="<%= pageNum-1 %>"/>	
<input type="submit" value="< prev page"/>
</form>	
<form>
<input type="hidden" name="page" value="home"/>
<input type="hidden" name="n" value="<%= pageNum+1 %>"/>	
<input type="submit" value="next page >"/>
</form>	
<%	
	} else if (pageNum > 1) {
%>
<form>
<input type="hidden" name="page" value="home"/>
<input type="hidden" name="n" value="<%= pageNum-1 %>"/>	
<input type="submit" value="< prev page"/>
</form>		
<%	
	}
} // else {
%>
</div> <!-- END content -->
<jsp:include page="/res/template/Footer.jsp" flush="true"/>
</body>
</html>