<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ include file="../includes/header.jsp"%>

<div id="table">
<div id="main">
<form id="loginForm" action="/Itea_shop_test_Spring/login" method="post">
	<div>
		<label>Enter your login:</label>
		<div class="input">
			<input type="text" name="Login" value="" id="login" />
		</div>
	</div>
	<div>
		<label>Enter
			your password:</label>
		<div class="input">
			<input type="password" name="Password" value="" id="pass" />
		</div>
	</div>

	<div>
		<button type="submit">Enter</button>
	</div>

</form>
</div>
</div>

<%@ include file="../includes/footer.jsp"%>