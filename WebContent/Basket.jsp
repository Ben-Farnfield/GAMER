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
				<c:choose>
					<c:when test="${basket.numItemsInBasket == 0}">
						<p id="no-items">There are currently no items in your basket</p>
					</c:when>
					<c:otherwise>
						<table id="bask-tab">
							<thead>
								<tr>
									<th class="bask-item, heading">Basket Item</th>
									<th class="bask-spacer heading"> </th>
									<th class="heading" colspan="3">Quantity</th>
									<th> </th>
									<th> </th>
									<th class="bask-price heading">Price ( £ )</th>
								</tr>
							</thead>
							<tfoot>
								<tr>
									<td> </td>
									<td class="bask-spacer"> </td>
									<td colspan="4"></td>
									<td id="bask-total-lab">total:</td>
									<td id="bask-total-fig" class="bask-price">${basketOfProducts.totalCostOfBasket}</td>
								</tr>
							</tfoot>
							<tbody>
							<c:forEach var="product" items="${basketOfProducts.productsInBasket}">
								<tr id="row-${product.key.id}">
									<td class="bask-item">
										<c:out value="${product.key.name}"/>
										<input id="price-${product.key.id}" type="hidden" value="${product.key.price}"/>
									</td>
									<td class="bask-spacer"> </td>
									<td>
										<input class="quan-min" type="submit" value="-" name="${product.key.id}"/>
									</td>
									<td>
										<input id="${product.key.id}" class="quan" type="text" name="quantity" value="${product.value}" readonly/>
									</td>
									<td>
										<input class="quan-plus" type="submit" value="+" name="${product.key.id}"/>
									</td>
									<td>
										<input class="rem-item" type="submit" value="remove item" name="${product.key.id}"/>
									</td>
									<td> </td>
									<td id="bask-price-${product.key.id}" class="bask-price">
										<c:out value="${product.key.price * product.value}"/>
									</td>
								</tr>
							</c:forEach>
							</tbody>
						</table>
						<table>
							<tr>
								<td id="purchase">
									<input id="pur-button" type="submit" value="Purchase"/>
								</td>
							</tr>
						</table>
					</c:otherwise>
				</c:choose>
			</div>
		</div> <!-- END content -->
		<jsp:include page="/res/template/Footer.jsp" flush="true"/>
	</body>
</html>