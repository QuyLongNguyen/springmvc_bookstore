<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
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
			
			<tr><td colspan="2" align="center"> <a href="${viewBook}">View more books</a> </td> </tr>	
				
		</c:forEach>

	</table>

	<security:authorize access="isAuthenticated()">
		<security:authentication property="principal" var="principal"/>
		
		 <h3>Hello, ${principal.username}</h3>
  		<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="logout"> 
		</form:form>
		
	</security:authorize> 
	<security:authorize access="!isAuthenticated()">  
  		<form:form action="login" method="GET">
  			<input type="submit" value="login">
  		</form:form>
	</security:authorize> 
	
</body>
</html>