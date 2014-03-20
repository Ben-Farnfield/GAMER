<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.gamer.beans.ProductBean,com.gamer.beans.ProductBeansWrapper" %>
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
<link rel="stylesheet" type="text/css" href="/GAMER/res/css/PagesBar.css">
</head>
<body class="games">
<jsp:include page="/res/template/TopBar.jsp" flush="true"/>
<jsp:include page="/res/template/Header.jsp" flush="true"/>
<jsp:include page="/res/template/Nav.jsp" flush="true"/>
<div id="content">
<%	
if (session.getAttribute("gamer.products") == null) {
	response.sendRedirect("/GAMER/shop?page=games");
}
%>
<jsp:include page="/res/template/ProductDisplay.jsp" flush="true"/>
<jsp:include page="/res/template/PagesBar.jsp" flush="true"/>
</div> <!-- END content -->
<jsp:include page="/res/template/Footer.jsp" flush="true"/>
</body>
</html>