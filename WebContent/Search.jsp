<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page trimDirectiveWhitespaces="true" %>
<c:if test="${empty productViewHelper}">
	<jsp:forward page="/shop?action=home"/>
</c:if>
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
		<link rel="stylesheet" type="text/css" href="/GAMER/res/css/Search.css">
		<link rel="stylesheet" type="text/css" href="/GAMER/res/css/PagesBar.css">
		<script src="/GAMER/res/js/lib/jquery-1.11.0.js"></script>
	</head>
	<body class="search">
		<jsp:include page="/res/template/TopBar.jsp" flush="true"/>
		<jsp:include page="/res/template/Header.jsp" flush="true"/>
		<jsp:include page="/res/template/Nav.jsp" flush="true"/>
		<div id="content">
			<c:choose>
				<c:when test="${empty productViewHelper.productsForPage}">
					<div id="no-result-div">
						<table id="no-result-table">
							<tr>
								<td id="no-result">No results found for "<c:out value="${param['keywords']}"/>"</td>
							</tr>
						</table>
					</div>
				</c:when>
				<c:otherwise>
					<jsp:include page="/res/template/ProductDisplay.jsp" flush="true"/>
				</c:otherwise>
			</c:choose>
			<jsp:include page="/res/template/PagesBar.jsp" flush="true"/>
		</div> <!-- END content -->
		<jsp:include page="/res/template/Footer.jsp" flush="true"/>
	</body>
</html>