
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<title>Hogwarts-Bookstore</title>
<style>
.error {
	color: red;
}
</style>
</head>

<body>



	<h1>Category form</h1>
	<form:form action="save-category" modelAttribute="category"
		method="POST">
		<form:hidden path="categoryId"/>
		<table>

			<tr>
				<td><label>Category name:</label></td>
				<td><form:input path="categoryName" /> <form:errors cssClass="error"
						path="categoryName" /></td>

			</tr>


			<tr>
				<td><label></label></td>
				<td><input type="submit" value="Save" /></td>
			</tr>



		</table>
	</form:form>

	<a href="${pageContext.request.contextPath}/admin/categories">Back to
		admin page</a>
</body>
</html>