<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.gamer.beans.Product" %>
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
		<link rel="stylesheet" type="text/css" href="/GAMER/res/css/LoginRegister.css">
		<script src="http://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
	</head>
	<body class="login">
		<jsp:include page="/res/template/TopBar.jsp" flush="true"/>
		<jsp:include page="/res/template/Header.jsp" flush="true"/>
		<jsp:include page="/res/template/Nav.jsp" flush="true"/>
		<div id="content">
			<div id="reg-cont">
				<h2>Login</h2>
				<form method="post" onsubmit="">
					<table>
						<tr>
							<td class="input-title">E-mail:</td>
							<td class="input"><input id="email" type="text" maxlength="32" name="dob"></td>
							<td id="error-email" class="error-msg"></td>
						</tr>
						<tr>
							<td class="input-title">Password:</td>
							<td class="input"><input id="pass" type="text" maxlength="32" name="password"></td>
							<td id="error-pass" class="error-msg"></td>
						</tr>
						<tr>
							<td colspan="3" align="center"><input id="submit-button" type="submit" value="Submit" /></td>
						</tr>
					</table>
				</form>
				<p>If you're not registered then go ahead and <a href="register.html">register</a> now.</p>
			</div>
		</div> <!-- END content -->
		<jsp:include page="/res/template/Footer.jsp" flush="true"/>
	</body>
</html>