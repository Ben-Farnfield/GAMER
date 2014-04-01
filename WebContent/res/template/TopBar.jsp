<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true" %>
<div id="top-bar">
<div id="inner-top-bar">
<table>
<tr>
<td>
	<c:if test="${not empty loggedInCustomer.forename}">logged in as ${loggedInCustomer.forename}</c:if>
</td>
<td>
	<form method="post" action="shop?action=search">
		<input id="search-field" type="text" size="32" name="keywords"/>
		<input id="search-button" type="submit" value=" " />
	</form>
</td>
<td>
	<c:choose>
		<c:when test="${empty loggedInCustomer}">
			<a href="/GAMER/shop?action=login">login</a>
		</c:when>
		<c:otherwise>
			<a href="/GAMER/shop?action=logout">logout</a>
		</c:otherwise>
	</c:choose>
</td>
<td><a href="/GAMER/shop?action=register">register</a></td>
</tr>
</table>
</div> <!-- END inner-top-bar -->
</div> <!-- END top-bar -->