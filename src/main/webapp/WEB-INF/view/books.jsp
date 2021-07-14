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
			<h2>All books of ${category.categoryName}</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<table>
				<tr>
					<th>Title</th>
					<th>Publish year</th>
					<th>Price</th>
					<th></th>
				</tr>
				
				<!-- loop over and print our customers -->
				<c:forEach var="book" items="${books}">
					<c:url var="viewDetail" value="/books">
						
					</c:url>
					<tr>
						<td> ${book.title} </td>
						<td> ${book.publishYear} </td>
						<td> ${book.price} </td>
						<td> <a href="${viewDetail}/${book.bookId}">View detail</a></td>
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
		<a href="${pageContext.request.contextPath}/home">Back</a>
	</div>
	

</body>

</html>


