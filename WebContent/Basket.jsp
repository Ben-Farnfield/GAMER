<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<link rel="stylesheet" type="text/css" href="/GAMER/res/css/Basket.css">
		<link rel="stylesheet" type="text/css" href="/GAMER/res/css/UserMsg.css">
		<link rel="stylesheet" type="text/css" href="/GAMER/res/css/Footer.css">
		<script src="/GAMER/res/js/lib/jquery-1.11.0.js"></script>
		<script src="/GAMER/res/js/basket.js"></script>
	</head>
	<body class="basket">
		<jsp:include page="/res/template/TopBar.jsp" flush="true"/>
		<jsp:include page="/res/template/Header.jsp" flush="true"/>
		<jsp:include page="/res/template/Nav.jsp" flush="true"/>
		<div id="content">
			<div id="basket-content">
				<table id="bask-tab">
					<thead>
						<tr>
							<th class="bask-item, heading">Basket Item</th>
							<th class="bask-spacer heading"> </th>
							<th> </th>
							<th class="heading" colspan="3">Quantity</th>
							<th> </th>
							<th> </th>
							<th class="line-price heading">Price ( £ )</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<td> </td>
							<td class="bask-spacer"> </td>
							<td colspan="5"></td>
							<td id="bask-total-lab">total:</td>
							<td id="bask-total-fig" class="line-price">${basket.totalCostOfBasket}</td>
						</tr>
					</tfoot>
					<tbody>
					<c:forEach var="product" items="${basket.allProductsInBasket}">
						<tr id="row-${product.product.id}">
							<td class="bask-item">
								<c:out value="${product.product.name}"/>
							</td>
							<td class="bask-spacer"></td>
							<c:choose>
								<c:when test="${product.enoughStock}">
									<td class="stock">${product.product.stock} in stock</td>
								</c:when>
								<c:otherwise>
									<td class="stock stock-warning">not enough stock,<br/>only ${product.product.stock} available</td>
								</c:otherwise>
							</c:choose>
							<td>
								<input class="quan-min" type="submit" value="-" name="${product.product.id}"/>
							</td>
							<td>
								<input id="quan-${product.product.id}" class="quan" type="text" name="quantity" value="${product.quantity}" readonly/>
							</td>
							<td>
								<input class="quan-plus" type="submit" value="+" name="${product.product.id}"/>
							</td>
							<td>
								<input class="rem-item" type="submit" value="remove item" name="${product.product.id}"/>
							</td>
							<td> </td>
							<td id="line-price-${product.product.id}" class="line-price">
								<c:out value="${product.linePrice}"/>
							</td>
						</tr>
					</c:forEach>
					</tbody>
				</table>
				<table>
					<tr>
						<td id="purchase">
							<form action="shop?action=purchase" method="post">
								<input id="pur-button" type="submit" value="Purchase"/>
							</form>
						</td>
					</tr>
				</table>
			</div>
		</div> <!-- END content -->
		<jsp:include page="/res/template/Footer.jsp" flush="true"/>
	</body>
</html>