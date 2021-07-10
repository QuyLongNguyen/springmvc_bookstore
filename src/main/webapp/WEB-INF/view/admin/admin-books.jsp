 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title></title>
</head>

<body>

	<h1>Admin page</h1>
	
	<form >
		<input type="button" value="Add book" 
		onclick="window.location.href='${pageContext.request.contextPath}/admin/add-book'"> 
	</form>
	<table>
		<tr> 
			<th>Title</th>
			<th>Author</th>
			<th>Publish year</th>
			<th>Description</th>
			<th>Price</th>
			<th>Category</th>
			<th>Action
		</tr>
		
		<c:forEach items="${books}" var="book"> 
		<c:url var="updateLink" value="update-book">
						<c:param name="bookId" value="${book.bookId}" />
		</c:url>
		<c:url var="deleteLink" value="delete-book">
						<c:param name="bookId" value="${book.bookId}" />
		</c:url>
			<tr>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td>${book.publishYear}</td>
				<td width="300px">${book.description}</td>
				<td>${book.price}</td> 
				<td>${book.category.categoryName}</td>
				<td><a href="${updateLink}">Update</a> | 
				<a href="${deleteLink}" onclick="return confirm('Are you sure?')" >Delete</a></td>
			</tr>
		</c:forEach>
		
	</table>
	<a href="${pageContext.request.contextPath}/admin">Back to admin page</a>
</body>
</html>