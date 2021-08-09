<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title></title>
</head>

<body>

	 <div class="wrapper">
      <jsp:include page="sidebar.jsp"></jsp:include>
      <!-- Page Content  -->
      <div id="content">
			<div class="row mb-3">
       	
       		<div class="col-xl-1">
       			<button type="button" id="sidebarCollapse" class="btn btn-info">
                        <i class="fas fa-align-left"></i>
                 </button>
       		</div>
       		<div class="col-xl-10 text-center h3">
        	Bills Management
         </div>
         </div>
	<table class="table">
		<tr>

			<th scope="col">Bill id</th>
			<th scope="col">User id</th>
			<th scope="col">Created Date</th>
			<th scope="col">Status</th>
			<th scope="col"></th>
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
				<td><a href="${pageContext.request.contextPath}/admin/bills/${bill.billId}"> Set status </a> </td>

			</tr>
		</c:forEach>

	</table>
	</div>
	</div>
	
</body>
</html>