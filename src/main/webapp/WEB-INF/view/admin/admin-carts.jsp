<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        	Carts Management
         </div>
         </div>
	
	
	<table class="table">
	<thead>
		<tr> 
			<th scope="col">ID</th>
			<th scope="col">User ID</th>
			<th scope="col">Date created</th>
			<th scope="col"></th>
			<th scope="col"></th>
		</tr>
	</thead>
		<c:forEach items="${carts}" var="cart"> 
		<c:url var="viewDetail" value="/admin/carts">
						<c:param name="id" value="${cart.cartId}" />
		</c:url>
		<c:url var="deleteLink" value="/admin/books/delete-book">
						<c:param name="bookId" value="${book.bookId}" />
		</c:url>
			<tr>
				<td scope="row">${cart.cartId}</td>
				<td>${cart.user.id}</td>
				<td>${cart.dateCreated}</td>
				<td><a href="${viewDetail}">View detail</a> </td>
				<td><a href="${deleteLink}" onclick="return confirm('Are you want to delete ${book.title} ?')" >Clear</a></td>
			</tr>
		</c:forEach>
		
	</table>
	</div>
	</div>
</body>
</html>