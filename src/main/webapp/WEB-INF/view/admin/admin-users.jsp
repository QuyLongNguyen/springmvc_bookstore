 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        	Users Management
         </div>
         </div>
	
	
	<table class="table">
	<thead>
		<tr> 
			<th scope="col">ID</th>
			<th scope="col">User name</th>
			<th scope="col">Roles</th>
			<th scope="col"></th>
			<th scope="col"></th>
			
		</tr>
	</thead>
		<c:forEach items="${users}" var="user"> 
		
		<c:url var="viewDetail" value="/admin/users">
						<c:param name="id" value="${user.id}" />
		</c:url>
		
			<tr>
				<td scope="row">${user.id}</td>
				<td>${user.userName}</td>
				<td>
				<c:forEach items="${user.roles}" var="role">
					${role.name}<br>
				</c:forEach>
				</td>
				<td><a href="#">View bills</a></td>
				<td><a href="${viewDetail}">Detail</a> | 
				<a href="${viewDetail}">Set roles</a></td>
				<td></td>
			</tr>
		</c:forEach>
		
	</table>
	</div>
	</div>
	<a href="${pageContext.request.contextPath}/admin/categories">Back</a>
</body>
</html>