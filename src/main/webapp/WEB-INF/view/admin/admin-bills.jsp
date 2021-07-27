<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title></title>
</head>

<body>

	<h1>Admin bill</h1>

	<table>
		<tr>

			<th>Bill id</th>
			<th>User id</th>
			<th>Created Date</th>
			<th>Status</th>
			<th>Action</th>
		</tr>

		<c:forEach items="${bills}" var="bill">
			<c:url var="updateLink" value="/admin/categories/update-category">
				<c:param name="categoryId" value="${category.categoryId}" />
			</c:url>
		
			<tr>

				<td>${bill.billId}</td>
				<td>${bill.user.id}</td>
				<td>${bill.dateCreated}</td>
				<td>${bill.status.statusType}</td>
				<td><a href="${pageContext.request.contextPath}/admin/bills/${bill.billId}"> View </a> </td>

			</tr>
		</c:forEach>

	</table>
	<a href="${pageContext.request.contextPath}/admin">Back to admin page</a>
</body>
</html>