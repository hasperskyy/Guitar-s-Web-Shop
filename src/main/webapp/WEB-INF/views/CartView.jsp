<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ include file="../includes/header.jsp"%>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>

<div id ="table">
<c:choose>
<c:when test="${cart != null}">
<table width = '700px' border='0'>
	<tr id = "head">
		<td width = '20px'></td>
		<td>Название</td>
		<td>Цена</td>
		<td>Кол-во</td>
		<td>Сумма</td>
		<td></td>
	</tr>
	<c:set var = "sum" value = "0" />
	<c:set var = "number" value = "1" />
	<c:forEach var="product" items="${cart.entrySet()}">
	<tr align = 'center'>
		<td align = 'left'>${number}</td>
		<c:set var = "number" value = "${number+1}"/>
		<td align = 'left'>${product.getKey().getName()}</td>
		<td>${product.getKey().getPrice()}</td>
		<td><span id = "numberProduct${product.getKey().getId()}">${product.getValue()}</span> </td>
		<td>${product.getKey().getPrice()*product.getValue()}</td>
		<c:set var = "temp" value = "${product.getKey().getPrice()*product.getValue()}" />
		<c:set var = "sum" value = "${sum + temp}" />
		<td>
		<input type = "button" height = "20" width = "20" id = "minusProduct${product.getKey().getId()}" 
			 name = "-" value = "-" onclick = "minusProduct(${product.getKey().getId()})"/>
		<input type = "button" height = "20" width ="20" id = "plusProductPlus${product.getKey().getId()}"
			name = "+" value = "+" onclick = "plusProduct(${product.getKey().getId()})" />
		<input type = "button" id = "clearProduct${product.getKey().getId()}" name = "Remove" value = "Удалить" 
			onclick = "removeProduct(${product.getKey().getId()})" />
		</td>
		</tr>
	</c:forEach>
	<tr><td height = "20px"></td></tr>
	<tr align='center'>
		<td></td>
		<td>Общая стоимость</td><td></td>
		<td>${sum}</td>
		<td>
		<input type = "button" id = "clearCart" name = "ClearCart" value = "Очистить корзину" onclick = "clearCart()"/>
		</td>
		</tr>

</table>
</c:when>
<c:otherwise>
<div id="main">
Ваша корзина - пуста
</div>
</c:otherwise>
</c:choose>
</div>

<%@ include file="../includes/footer.jsp"%>

<script>

function minusProduct(id) {
$.ajax({
	url: './cart',
	method: 'post',
	dataType: 'html',
	data: {'minusProduct': id},
	success: function success(data){
			
			var general = data.indexOf("general");
			var beginOfGeneral = data.indexOf(">", general);
			var endOfGeneral = data.indexOf("</div>", general);
			var summ1 = data.substring(beginOfGeneral+1,endOfGeneral);
			$('#general').html(summ1);
			
			var table = data.indexOf("table");	
			var beginOfTable = data.indexOf(">", table);
			var endOfTable = data.indexOf("</div>", table);
			var summ2 = data.substring(beginOfTable+1, endOfTable);
			$('#table').html(summ2);
	},
	
	error: function error () {
		alert("не удалось уменьшить");
	}
});

}

function plusProduct(id) {
	
$.ajax({
	url: './cart',
	method: 'post',
	dataType: 'html',
	data: {'plusProduct': id},
	success: function success(data){
		
			var general = data.indexOf("general");
			var beginOfGeneral = data.indexOf(">", general);
			var endOfGeneral = data.indexOf("</div>", general);
			var summ1 = data.substring(beginOfGeneral+1,endOfGeneral);
			$('#general').html(summ1);
			
			var table = data.indexOf("table");	
			var beginOfTable = data.indexOf(">", table);
			var endOfTable = data.indexOf("</div>", table);
			var summ2 = data.substring(beginOfTable+1, endOfTable);
			$('#table').html(summ2);
	},
	
	error: function error () {
		alert("не удалось увеличить");
	}
});

}

function removeProduct(id) {
	
$.ajax({
	url: './cart',
	method: 'post',
	dataType: 'html',
	data: {'removeProduct': id},
	success: function success(data){
		
			var general = data.indexOf("general");
			var beginOfGeneral = data.indexOf(">", general);
			var endOfGeneral = data.indexOf("</div>", general);
			var summ1 = data.substring(beginOfGeneral+1,endOfGeneral);
			$('#general').html(summ1);
			
			var table = data.indexOf("table");	
			var beginOfTable = data.indexOf(">", table);
			var endOfTable = data.indexOf("</div>", table);
			var summ2 = data.substring(beginOfTable+1, endOfTable);
			$('#table').html(summ2);
	},
	
	error: function error () {
		alert("не удалось удалить товар");
	}
});

}

function clearCart() {
	
$.ajax({
	url: './cart',
	method: 'post',
	dataType: 'html',
	data: {'clearCart': 'removeAll'},
	success: function success(data){
		
			var general = data.indexOf("general");
			var beginOfGeneral = data.indexOf(">", general);
			var endOfGeneral = data.indexOf("</div>", general);
			var summ1 = data.substring(beginOfGeneral+1,endOfGeneral);
			$('#general').html(summ1);
			
			var table = data.indexOf("table");	
			var beginOfTable = data.indexOf(">", table);
			var endOfTable = data.indexOf("</div>", table);
			var summ2 = data.substring(beginOfTable+1, endOfTable);
			$('#table').html(summ2);
	},
	
	error: function error () {
		alert("не удалось очистить корзину");
	}
});
}

 </script>
