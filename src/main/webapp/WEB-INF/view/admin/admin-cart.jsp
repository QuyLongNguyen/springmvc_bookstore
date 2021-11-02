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
	 <div class="line"> </div>
	<div class="row">
		<div class="col-xl-1">
			<a href="${pageContext.request.contextPath}/admin/carts" class="btn btn-info mt-n2">Back</a>
		</div>
		<div class="col-xl-2">
			ID: ${cart.cartId}
		</div>
		<div class="col-xl-2">
			User ID: ${cart.user.id}
		</div>
		<div class="col-xl-4">
			Date created: ${cart.dateCreated}
		</div>
	</div>
	
	 <div class="line"> </div>
	<table class="table">
	<thead>
		<tr> 
			<th scope="col">ID</th>
			<th scope="col">Book</th>
			<th scope="col">Quantity</th>
			<th scope="col">Price</th>
			<th scope="col">Sub total</th>
		</tr>
	</thead>
		<c:set var="total" value="${0}"></c:set>
		<c:forEach items="${items}" var="item"> 
		
			<tr>
				<td scope="row">${item.itemId}</td>
				<td>${item.book.title}</td>
				<td>${item.quantity}</td>
				<td>${item.book.price}</td>
				
				<td>${item.quantity * item.book.price}</td>
				
			</tr>
		</c:forEach>
		
	</table>
	</div>
	</div>
</body>
</html>