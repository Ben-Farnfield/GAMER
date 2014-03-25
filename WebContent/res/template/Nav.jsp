<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="nav">
	<ul>
		<li>
			<a id="home" href="/GAMER/shop?action=home">Home 
				<span class="status-info"></span>
			</a>
		</li>
		<li>
			<a id="toys" href="/GAMER/shop?action=toys">Toys 
				<span class="status-info"></span>
			</a>
		</li>
		<li>
			<a id="games" href="/GAMER/shop?action=games">Games 
				<span class="status-info"></span>
			</a>
		</li>
		<li>
			<a id="basket" href="/GAMER/shop?action=basket">Basket 
				<span class="status-info" id="basket-num">
					<c:choose>
						<c:when test="${not empty basket}">
							<c:out value="( ${basket.numItemsInBasket} )"></c:out>
						</c:when>
						<c:otherwise>
							<c:out value="( 0 )"></c:out>
						</c:otherwise>
					</c:choose>
				</span>
			</a>
		</li>
	</ul>
</div> <!-- END nav -->