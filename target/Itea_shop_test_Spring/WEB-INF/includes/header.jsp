<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<html>
<head>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<title>Guitar Shop</title>
<link href="styles/style.css" rel="stylesheet" type="text/css" media="screen" />
<script type="text/javascript" src="javascript/jquery-1.6.2.min.js"></script>
<script type="text/javascript" src="javascript/jquery.poptrox-0.1.js"></script>
</head>
<body>

<div id="header" class="container">
	<div id="logo">
		<h1><a href="#">Музыкальный магазин </a></h1>
	</div>
	<div id="menu">
		<ul>
			<li class="current_page_item"><a href="/Itea_shop_test_Spring/main">Главная</a></li>
			<li><a href="/Itea_shop_test_Spring/products">Товары</a></li>
			<c:choose>
			<c:when test = "${userS != null}">
			<li><a href="/Itea_shop_test_Spring/corr">Редактировать</a></li>
			<li><a href="/Itea_shop_test_Spring/login?Logout=ok">Выход</a></li>
			</c:when>
			<c:otherwise>
			<li><a href="/Itea_shop_test_Spring/register">Регистрация</a></li>
			<li><a href="/Itea_shop_test_Spring/login">Вход</a></li>
			</c:otherwise>
			</c:choose>
			<li><a href="/Itea_shop_test_Spring/cart">Корзина</a></li>
		</ul>
		
	</div>
</div>
<!-- end #header -->

<div id="label">
	<!-- start -->
	<ul id="gallery">
		<li><a href = "/Itea_shop_test_Spring/products?Category=1"><img src="images/guitars_1.jpg" title = "Классические гитары"/></a></li>
		<li><a href = "/Itea_shop_test_Spring/products?Category=2"><img src="images/guitars_2.jpg" title = "Эстрадные гитары"/></a></li>
		<li><a href = "/Itea_shop_test_Spring/products?Category=3"><img src="images/guitars_3.jpg" title = "Электрогитары"/></a></li>	
	</ul>
	<!-- end -->
</div>

<div id="sidebar">
	
	<div> Вы авторизировались, как ${userS.getName()} </div>
	<div id = "general"> В вашей корзине ${generalQuantity} товар(ов)</div>

	<h2>Товары</h2>
	<ul>
		<li><a href="/Itea_shop_test_Spring/products?Category=1">Классические гитары</a></li>
		<li><a href="/Itea_shop_test_Spring/products?Category=2">Эстрадные гитары</a></li>
		<li><a href="/Itea_shop_test_Spring/products?Category=3">Электрогитары</a></li>
		<c:choose>
			<c:when test = "${userS != null}">
			<li><a href="/Itea_shop_test_Spring/corr">Редактировать</a></li>
			<li><a href="/Itea_shop_test_Spring/login?Logout=ok">Выход</a></li>
			</c:when>
			<c:otherwise>
			<li><a href="/Itea_shop_test_Spring/register">Регистрация</a></li>
			<li><a href="/Itea_shop_test_Spring/login">Вход</a></li>
			</c:otherwise>
			</c:choose>
		<li><a href="/Itea_shop_test_Spring/cart">Корзина</a></li>
	</ul>
</div>
		