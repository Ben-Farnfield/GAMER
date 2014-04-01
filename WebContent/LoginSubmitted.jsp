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
		<script src="/GAMER/res/js/lib/jquery-1.11.0.js"></script>
		<script src="/GAMER/res/js/register.js"></script>
	</head>
	<body class="login">
		<jsp:include page="/res/template/TopBar.jsp" flush="true"/>
		<jsp:include page="/res/template/Header.jsp" flush="true"/>
		<jsp:include page="/res/template/Nav.jsp" flush="true"/>
		<div id="content">
			<div id="reg-cont">
				<form method="post" action="shop?action=login-submit" accept-charset="UTF-8">
					<fieldset class="reg-log">
						<legend>Login</legend>
						<table>
							<tr>
								<td class="input-title">E-mail:</td>
								<td class="input"><input type="text" maxlength="100" name="email" value="${loginViewHelper.email}"></td>
								<td class="input-spacer"></td>
							</tr>
							<tr id="email-error" class="error" <c:if test="${loginViewHelper.validEmail}">style="display:none;"</c:if>>
								<td colspan="3">${loginViewHelper.emailErrorMsg}</td>
							</tr>
							<tr>
								<td class="input-title">Password:</td>
								<td class="input"><input type="password" maxlength="16" name="password" value="${loginViewHelper.password}"></td>
								<td class="input-spacer"></td>
							</tr>
							<tr id="password-error" class="error" <c:if test="${loginViewHelper.validPassword}">style="display:none;"</c:if>>
								<td colspan="3">${loginViewHelper.passwordErrorMsg}</td>
							</tr>
							<tr id="password-not-found-error" class="error" <c:if test="${ !loginViewHelper.validPassword || !loginViewHelper.validEmail}">style="display:none;"</c:if>>
								<td colspan="3">${loginViewHelper.passwordNotFoundErrorMsg}</td>
							</tr>
						</table>
					</fieldset>
					<input id="submit" type="submit" value="Submit" />
				</form>
				<p>If you're not registered then go ahead and <a href="/GAMER/shop?action=register">register</a> now.</p>
			</div>
		</div> <!-- END content -->
		<jsp:include page="/res/template/Footer.jsp" flush="true"/>
	</body>
</html>