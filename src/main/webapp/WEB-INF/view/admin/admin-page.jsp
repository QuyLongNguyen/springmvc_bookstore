 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<title></title>
</head>

<body>

	<h1>Admin page</h1>
	<a href="${pageContext.request.contextPath}/admin/categories">Products management</a>
	<a href="${pageContext.request.contextPath}/admin/bills">Bills management</a>
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
		<input type="submit" value="logout"> 
	</form:form>
</body>
</html>