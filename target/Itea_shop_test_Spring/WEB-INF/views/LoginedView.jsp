<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ include file="../includes/header.jsp"%>

<div id="table">
<div id = "main">

	<h1>Hello, ${userS.getName()}!</h1>
	<br> login: ${userS.getLogin()}
	<br> region: ${userS.getRegion()}
	<br> gender:
	<c:choose>
		<c:when test="${userS.getGender() == 1}">
		male
	</c:when>
		<c:otherwise>
		female
	</c:otherwise>
	</c:choose>
	<br> comment: ${userS.getComment()}
</div>
</div>

<%@ include file="../includes/footer.jsp"%>