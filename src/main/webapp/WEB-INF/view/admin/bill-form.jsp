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

	<h1>Bill form</h1>
	
	<form:form action="saveBill" modelAttribute="bill" method="POST">
		<form:hidden path="billId"/>
		<table>
			
			<tr>
				<td><label>Status type:</label></td>
				<td><form:select path="statusId">
				<c:forEach items="${status}" var="temp">
					<c:choose>
						
							<c:when test="${temp.statusId == bill.status.statusId}">
								<option value = "${temp.statusId}" selected="selected">${temp.statusType}</option>
							</c:when>
							<c:otherwise>
								<option value = "${temp.statusId}">${temp.statusType}</option>
							</c:otherwise>
						
					
					</c:choose>
						</c:forEach>	
				
				</form:select></td>
				
			</tr>
			<tr>
				<td><label></label></td>
				<td><input type="submit" value="Save" /></td>
			</tr>
		</table>
	</form:form>
	<table>
	
		<tr>

			<th>Item id</th>
			<th>Book id</th>
			<th>Price</th>
			<th>Quantity</th>
			
		</tr>

		<c:forEach items="${billItems}" var="billItem">
			
			<tr>

				<td>${billItem.billItemId}</td>
				<td>${billItem.book.bookId}</td>
				<td>${billItem.price}</td>
				<td>${billItem.quantity}</td>
			</tr>
		</c:forEach>

	</table>
	
	<a href="${pageContext.request.contextPath}/admin/bills">Back to bills page</a>

	
</body>
</html>