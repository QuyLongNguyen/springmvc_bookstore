<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title></title>
</head>

<body>

	<h1>Admin categories</h1>

	<form>
		<input type="button" value="Add category"
			onclick="window.location.href='${pageContext.request.contextPath}/admin/categories/add-category'">
	</form>
	<table>
		<tr>

			<th>Category name</th>
			<th>Action
		</tr>

		<c:forEach items="${categories}" var="category">
			<c:url var="updateLink" value="/admin/categories/update-category">
				<c:param name="categoryId" value="${category.categoryId}" />
			</c:url>
			<c:url var="deleteLink" value="/admin/categories/delete-category">
				<c:param name="categoryId" value="${category.categoryId}" />
			</c:url>
			<c:url var="viewBook" value="/admin/books">
				<c:param name="categoryId" value="${category.categoryId}" />
			</c:url>
			<tr>


				<td>${category.categoryName}</td>

				<td><a href="${updateLink}">Update</a> | <a
					href="${deleteLink}" onclick="return confirm('Are you sure?')">Delete</a>
					<a href="${viewBook}">View</a></td>
			</tr>
		</c:forEach>

	</table>
	<a href="${pageContext.request.contextPath}/admin/books">View all
		books</a>
	<br>
	<a href="${pageContext.request.contextPath}/admin">Back to admin
		page</a>
</body>
</html>