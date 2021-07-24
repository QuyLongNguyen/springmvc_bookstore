<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
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
			<h2>Details of ${book.title}</h2>
		</div>
	</div>
	<c:if test="${param.buy == true}">
				<script type="text/javascript">
					alert("Added to cart");
				</script>
		</c:if>
	<div id="container">
		
		<div id="content">
			
			<table>
				<tr>
					
					<th>Publish year</th>
					<th>Description </th>
					<th>Price</th>
					<th></th>
				</tr>
					<tr>
						
						<td> ${book.publishYear} </td>
						<td> ${book.description} </td>
						<td> ${book.price} </td>
						<form:form action="buy" modelAttribute="item" method="POST">
							<form:hidden path="itemId"/>
							<form:hidden path="bookId" value="${book.bookId}" />
							<td><form:input type="number" value ="1" min="1" path="quantity"/> </td>
							<td><input type="submit" value="add to cart"></td>
						</form:form>
					</tr>
					<c:url value="/books" var="back">
						<c:param name="categoryId" value="${book.category.categoryId}"></c:param>
					</c:url>
			</table>
				
		</div>
		
		<a href="${back}">Back</a>
	</div>
	

</body>

</html>


