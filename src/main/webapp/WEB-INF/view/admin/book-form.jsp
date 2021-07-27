 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
 
<html>
<head>
<title>Hogwarts-Bookstore</title>
<style>
.error{
	color: red;
}
</style>
</head>

<body>
	
	
		
	<h1>Book form</h1>
	<form:form action="save-book" modelAttribute="book" method="POST" enctype="multipart/form-data" >
		<form:hidden path="bookId"/>
		<table>
				
					<tr>
						<td><label>Title:</label></td>
						<td><form:input path="title" />
						<form:errors cssClass="error" path="title"/> </td>
						
					</tr>
				
					<tr>
						<td><label>Author:</label></td>
						<td><form:input path="author" /></td>
					</tr>
					
					<tr>
						<td><label>Publish year:</label></td>
						<td><form:input path="publishYear" /></td>
					</tr>

					<tr>
						<td><label>Description:</label></td>
						<td><form:textarea path="description" cols="40" rows="10"/>
					</tr>
					
					<tr>
						<td><label>Price:</label></td>
						<td><form:input path="price" />
						<form:errors cssClass="error" path="price"/> <td>
					</tr>
					
					<tr>
						<td><label>Quantity:</label></td>
						<td><form:input path="quantity" />
						<form:errors cssClass="error" path="price"/> <td>
					</tr>
					
					<tr>
						<td><label>Image:</label></td>
						<td><img width="100px" height="168px" alt="image" 
						src="${pageContext.request.contextPath }/resources/images/${book.cover}"> </td>
						
					</tr>
					<tr>
						<td><label></label></td>
						<td><form:input path="image" type="file"/><td>
						<form:hidden path="cover"/>
					</tr>
					<tr>
						<td><label>Category name:</label></td>
						<td><form:select path="categoryId">
							<c:forEach items="${categories}"  var="category">
								
									<form:option value="${category.categoryId}" label="${category.categoryName}"></form:option>
								
								
							</c:forEach> 
						</form:select> </td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" /></td>
					</tr>

				
				
			</table>
	</form:form>
	
	<a href="${pageContext.request.contextPath}/admin">Back to admin page</a>
</body>
</html>