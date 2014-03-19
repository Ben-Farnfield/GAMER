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
<body class="games">
<jsp:include page="/res/template/TopBar.jsp"  flush="true"/>
<jsp:include page="/res/template/Header.jsp"  flush="true"/>
<jsp:include page="/res/template/Nav.jsp"  flush="true"/>
<div id="content">
<%
@SuppressWarnings("unchecked")
ArrayList<ProductBean> products = 
	(ArrayList<ProductBean>)session.getAttribute("gamer.products");
if (products == null) {
	response.sendRedirect("/GAMER/shop?page=games");
} else {
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
} // else {
%>
</div> <!-- END content -->
<jsp:include page="/res/template/Footer.jsp"  flush="true"/>
</body>
</html>