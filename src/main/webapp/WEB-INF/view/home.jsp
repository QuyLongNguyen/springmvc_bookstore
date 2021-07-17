<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title></title>
</head>

<body>

	<h1>Home page</h1>
	<form action="books" method="get">
		<input type="text" name="keyword" placeholder="title or author you want..."> 
		<input type="submit" value="Search"> 
	</form>
	<table border="1px" >
		
		<c:forEach items="${categories}" var="category">
			
			<c:url var="viewBook" value="/books">
				<c:param name="categoryId" value="${category.categoryId}" />
			</c:url>
			
			<tr>
				<th colspan="2">${category.categoryName}</th>
			</tr>
			
			
			<tr>
				<c:forEach items="${category.books}" var="book" varStatus="loop">
				<c:if test="${loop.index < 2}">
					<td width="250px">${book.title}<br>
					${book.price}<br>
					</td>
				</c:if>
				</c:forEach>	
			</tr>
			<tr><td colspan="2" align="center"> <a href="${viewBook}">View more books</a> </td> </tr>	
				
		</c:forEach>

	</table>
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="logout"> 
	</form:form>
</body>
</html>