<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="/GAMER/res/js/basket.js"></script>
<c:forEach var="product" items="${productViewHelper.productsForPage}">
	<c:choose>
		<c:when test="${product.inBasket}">
			<c:set var="addedToBasketPic" value="/GAMER/res/img/misc/AddedToBasket.png"/>
		</c:when>
		<c:otherwise>
			<c:set var="addedToBasketPic" value=" "/>
		</c:otherwise>
	</c:choose>
	<div class="prod">
		<div class="highlight">
			<div class="prod-img" style="background-image:url(${product.pictureURI});">
				<img id="add-basket-${product.id}" class="add-bask-img" src="${addedToBasketPic}">
			</div>
			<h2>${product.name}</h2>
			<table>
				<tr>
					<td class="price"><h2>£ ${product.price}</h2></td>
					<td class="prod-stock">${product.stock} in stock</td>
				</tr>
			</table>
			<button class="basket_button" id="${product.id}">Add to Basket</button>
		</div>
	</div>
</c:forEach>
