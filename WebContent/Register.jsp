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
				<h2>Register</h2>
				<form method="post" action="shop?action=register-submit">
					<fieldset class="reg-log">
						<legend>Personal Details</legend>
						<table>
							<tr>
								<td class="input-title">Forename:</td>
								<td class="input"><input type="text" maxlength="32" name="forename"></td>
								<td class="input-spacer"></td>
							</tr>
							<tr>
								<td class="input-title">Surname:</td>
								<td class="input"><input type="text" maxlength="32" name="surname"></td>
								<td class="input-spacer"></td>
							</tr>
							<tr>
								<td class="input-title">E-mail:</td>
								<td class="input"><input id="email" type="text" maxlength="32" name="email"></td>
								<td class="input-spacer"></td>
							</tr>
							<tr>
								<td class="input-title">Password:</td>
								<td class="input"><input id="pass" type="password" maxlength="16" name="password"></td>
								<td class="input-spacer"></td>
							</tr>
							<tr>
								<td class="input-title">Confirm password:</td>
								<td class="input"><input type="password" maxlength="16" name="conf-password"></td>
								<td class="input-spacer"></td>
							</tr>
						</table>
					</fieldset>
					<fieldset class="reg-log">
						<legend>Billing Details</legend>
						<table>
							<tr>
								<td class="input-title">Credit card number:</td>
								<td class="input"><input type="text" maxlength="16" name="card-num"></td>
								<td class="input-spacer"></td>
							</tr>
						</table>
						<br/>
						<table>
							<tr>
								<td class="input-title">House number:</td>
								<td class="input"><input type="text" maxlength="4" name="house-num"></td>
								<td class="input-spacer"></td>
							</tr>
							<tr>
								<td class="input-title">Street name:</td>
								<td class="input"><input type="text" maxlength="32" name="street"></td>
								<td class="input-spacer"></td>
							</tr>
							<tr>
								<td class="input-title">Post code:</td>
								<td class="input"><input type="text" maxlength="7" name="postcode"></td>
								<td class="input-spacer"></td>
							</tr>
						</table>
					</fieldset>
					<input id="submit" type="submit" value="Submit" />
				</form>
				<p>If you've already registered then go ahead and <a href="/GAMER/shop?action=login">login</a>.</p>
			</div>
		</div> <!-- END content -->
		<jsp:include page="/res/template/Footer.jsp" flush="true"/>
	</body>
</html>