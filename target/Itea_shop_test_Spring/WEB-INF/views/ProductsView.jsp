<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<%@ include file="../includes/header.jsp"%>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>

<div id = "table">
<table id = 'main'>
	<tr id = 'head'> 
		<td>Название</td>
		<td></td>
		<td>Описание</td>
		<td>Цена</td>
		<td>Кол-во</td>
	</tr> 
	<c:forEach var="product" items="${productSet}">
		<tr>
			<td>${product.getName()}</td>
			<td><img src="images/productImage/${product.getId()}.jpg"
				height="200" weight="200"></td>
			<td id = 'description'>${product.getDescription()}</td>
			<td>${product.getPrice()}</td>
			<td width="70 px"><img src="images/-.png" height="20" width="20"
				id="-" onclick="minus(${product.getId()})" /> <span
				id="numberProduct${product.getId()}" />1</span> <img src="images/+.png"
				height="20" width="20" id="+" onclick="plus(${product.getId()})" />
				<input type="submit" id="buy" name="Buy" value="Buy"
				onclick="buy(${product.getId()})" /></td>
		</tr>
	</c:forEach>
</table>
</div>

<%@ include file="../includes/footer.jsp"%>

<script>
function minus(id) {
var number = document.getElementById("numberProduct" + id).innerHTML;
if (number>1) {
	number--;
	document.getElementById("numberProduct" + id).innerHTML = number;
	}
}

function plus (id) {
var number = document.getElementById("numberProduct" + id).innerHTML;
number++;
document.getElementById("numberProduct" + id).innerHTML = number;

}
function buy (id) {
var number = document.getElementById("numberProduct" + id).innerHTML;
if (number>=1) {
$.ajax({
	url: './cart',
	method: 'post',
	dataType: 'html',
	data: {'productToBuy': id, 'numberOfProduct': number},
	success: function success(data){
		
			var general = data.indexOf("general");
			var beginOfGeneral = data.indexOf(">", general);
			var endOfGeneral = data.indexOf("</div>", general);
			var summ1 = data.substring(beginOfGeneral+1,endOfGeneral);
			$('#general').html(summ1);
		},
	error: function error() {
			alert("Не удалось!");
	}
});
}
}


</script>