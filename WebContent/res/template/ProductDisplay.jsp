<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.gamer.beans.ProductBean, com.gamer.beans.ProductBeansWrapper" %>
<%
ProductBeansWrapper productBeans = 
	(ProductBeansWrapper)session.getAttribute("gamer.products");

int pageNum;
try {
	pageNum = Integer.parseInt(request.getParameter("n"));
} catch (NumberFormatException e) {
	pageNum = 1;
}

for (ProductBean product : productBeans.getProductsForPage(pageNum)) {
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
%>