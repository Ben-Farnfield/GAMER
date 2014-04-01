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
				<h2>Register</h2>
				<form method="post" action="shop?action=register-submit" accept-charset="UTF-8">
					<fieldset class="reg-log">
						<legend>Personal Details</legend>
						<table>
							<tr>
								<td class="input-title">Forename:</td>
								<td class="input"><input type="text" maxlength="32" name="forename" value="${registerViewHelper.forename}"></td>
								<td class="input-spacer"></td>
							</tr>
							<tr id="forename-error" class="error" <c:if test="${registerViewHelper.validForename}">style="display:none;"</c:if>>
								<td colspan="3">${registerViewHelper.forenameErrorMsg}</td>
							</tr>
							<tr>
								<td class="input-title">Surname:</td>
								<td class="input"><input type="text" maxlength="32" name="surname" value="${registerViewHelper.surname}"></td>
								<td class="input-spacer"></td>
							</tr>
							<tr id="surname-error" class="error" <c:if test="${registerViewHelper.validSurname}">style="display:none;"</c:if>>
								<td colspan="3">${registerViewHelper.surnameErrorMsg}</td>
							</tr>
							<tr>
								<td class="input-title">E-mail:</td>
								<td class="input"><input type="text" maxlength="32" name="email" value="${registerViewHelper.email}"></td>
								<td class="input-spacer"></td>
							</tr>
							<tr id="email-error" class="error" <c:if test="${registerViewHelper.validEmail}">style="display:none;"</c:if>>
								<td colspan="3">${registerViewHelper.emailErrorMsg}</td>
							</tr>
							<tr id="email-prev-used-error" class="error" <c:if test="${! registerViewHelper.emailInDatabase}">style="display:none;"</c:if>>
								<td colspan="3">${registerViewHelper.emailPrevUsedErrorMsg}</td>
							</tr>
							<tr>
								<td class="input-title">Password:</td>
								<td class="input"><input type="password" maxlength="16" name="password" value="${registerViewHelper.password}"></td>
								<td class="input-spacer"></td>
							</tr>
							<tr id="password-error" class="error" <c:if test="${registerViewHelper.validPassword}">style="display:none;"</c:if>>
								<td colspan="3">${registerViewHelper.passwordErrorMsg}</td>
							</tr>
							<tr>
								<td class="input-title">Confirm password:</td>
								<td class="input"><input type="password" maxlength="16" name="conf-password" value="${registerViewHelper.confPassword}"></td>
								<td class="input-spacer"></td>
							</tr>
							<tr id="conf-password-error" class="error" <c:if test="${registerViewHelper.matchForPassword}">style="display:none;"</c:if>>
								<td colspan="3">${registerViewHelper.confPasswordErrorMsg}</td>
							</tr>
						</table>
					</fieldset>
					<fieldset class="reg-log">
						<legend>Billing Details</legend>
						<table>
							<tr>
								<td class="input-title">Credit card number:</td>
								<td class="input"><input type="text" maxlength="16" name="card-num" value="${registerViewHelper.cardNum}"></td>
								<td class="input-spacer"></td>
							</tr>
							<tr id="card-num-error" class="error" <c:if test="${registerViewHelper.validCardNum}">style="display:none;"</c:if>>
								<td colspan="3">${registerViewHelper.cardNumErrorMsg}</td>
							</tr>
						</table>
						<br/>
						<table>
							<tr>
								<td class="input-title">House number:</td>
								<td class="input"><input type="text" maxlength="4" name="house-num" value="${registerViewHelper.houseNum}"></td>
								<td class="input-spacer"></td>
							</tr>
							<tr id="house-num-error" class="error" <c:if test="${registerViewHelper.validHouseNum}">style="display:none;"</c:if>>
								<td colspan="3">${registerViewHelper.houseNumErrorMsg}</td>
							</tr>
							<tr>
								<td class="input-title">Street name:</td>
								<td class="input"><input type="text" maxlength="32" name="street" value="${registerViewHelper.street}"></td>
								<td class="input-spacer"></td>
							</tr>
							<tr id="street-error" class="error" <c:if test="${registerViewHelper.validStreet}">style="display:none;"</c:if>>
								<td colspan="3">${registerViewHelper.streetErrorMsg}</td>
							</tr>
							<tr>
								<td class="input-title">Post code:</td>
								<td class="input"><input type="text" maxlength="7" name="postcode" value="${registerViewHelper.postcode}"></td>
								<td class="input-spacer"></td>
							</tr>
							<tr id="postcode-error" class="error" <c:if test="${registerViewHelper.validPostcode}">style="display:none;"</c:if>>
								<td colspan="3">${registerViewHelper.postcodeErrorMsg}</td>
							</tr>
						</table>
					</fieldset>
					<c:if test="${requestAction == 'purchase'}">
						<input type="hidden" name="requestAction" value="purchase">
					</c:if>
					<input id="submit" type="submit" value="Submit" />
				</form>
				<p>If you've already registered then go ahead and <a href="/GAMER/shop?action=login">login</a>.</p>
			</div>
		</div> <!-- END content -->
		<jsp:include page="/res/template/Footer.jsp" flush="true"/>
	</body>
</html>