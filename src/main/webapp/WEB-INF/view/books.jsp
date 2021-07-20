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
			<h2>All books of ${category}</h2>
		</div>
	</div>
	<form action="books" method="get">
		<input type="text" name="keyword" placeholder="title or author you want..."> 
		<input type="submit" value="Search"> 
	</form>
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
						
						<form:form action="books/buy" modelAttribute="item" method="POST">
							<form:hidden path="itemId"/>
							<form:hidden path="bookId" value="${book.bookId}" />
							<td><form:input path="quantity"/> </td>
							<td><input type="submit" value="add to cart"></td>
						</form:form>
						
					</tr>
				
				</c:forEach>		
			</table>
				
		</div>
		<a href="${pageContext.request.contextPath}/home">Back</a>
	</div>
	

</body>

</html>


