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
		<div class="prod-img" style="background-image:url(${product.pictureURI});">
			<img id="add-basket-${product.id}" class="add-bask-img" src="${addedToBasketPic}">
		</div>
		<h2>£ ${product.price} : ${product.name}</h2>
		<p>
			<em>Genre: ${product.genre}</em>
			<br/><br/>
			${product.description}
		</p>
		<button class="basket_button" id="${product.id}">Add to Basket</button>
	</div>
</c:forEach>
