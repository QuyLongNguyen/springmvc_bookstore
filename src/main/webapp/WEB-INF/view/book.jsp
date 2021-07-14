<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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


