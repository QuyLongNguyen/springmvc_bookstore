<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>

<html>

<head>
	<title>Hogwarts Bookstore</title>
	
	<!-- reference our style sheet 

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" /> -->

</head>

<body>

	<div >
		<div >
			<h2>Your cart</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
			<c:if test="${items.size() != 0 }">
				<form:form action="cart/buy" method="post">
				<input type="submit" value="buy"> 
			</form:form>
			</c:if>
			<table>
				<tr>
					<th>Title</th>
					<th>Quantity</th>
					<th>Unit price</th>
					<th>Sub total</th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:set var="priceTotal" value="${0}"></c:set>
				<c:set var="quantityTotal" value="${0}"></c:set>
				<c:forEach var="item" items="${items}">
					<c:url var="deleteItem" value="/cart/deleteItem">
						<c:param name="itemId" value="${item.itemId}"></c:param>
					</c:url>
					
					<c:url var="updateItem" value="/cart/updateItem">
						<c:param name="itemId" value="${item.itemId}"></c:param>
						<c:param name="quantity" value="${item.quantity}"></c:param>
					</c:url>
					
					
					<tr>
						<td> ${item.book.title} </td>
						<form:form action="cart/updateItem" method="get">
						<input type="hidden" value="${item.itemId}" name="itemId">
						<td><input type="number" value="${item.quantity}" name="quantity"></td>
						<td> ${item.book.price} </td>
						<td> ${item.book.price * item.quantity}  </td>
						<td><input type="submit" value="update" /></td>
						<c:set var="quantityTotal" value="${quantityTotal + item.quantity}"></c:set>
						<c:set var="priceTotal" value="${priceTotal + (item.book.price * item.quantity)}"></c:set>
						<td> <a href="${deleteItem}"  onclick="return confirm('Are you sure?')">Delete</a> </td>
						</form:form>
					</tr>
					
					 
				</c:forEach>	
				<tr>
					 	<td> Total: </td>
					 	<td>${quantityTotal} </td>
					 	<td> </td>
					 	<td>${priceTotal} </td>
					 <tr>	
			</table>
				
		</div>
		<a href="${pageContext.request.contextPath}/home">Back</a>
	</div>
	

</body>

</html>


