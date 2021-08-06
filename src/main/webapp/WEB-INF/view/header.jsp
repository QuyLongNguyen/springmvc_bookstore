<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<!doctype html>
<html>
	<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta charset="UTF-8">
		 <% response.setHeader("Cache-Control","no-cache"); //HTTP 1.1 
 		response.setHeader("Pragma","no-cache"); //HTTP 1.0 
 		response.setDateHeader ("Expires", 0); //prevents caching at the proxy server  %>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
		<link rel="stylesheet"
			href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css">
			<script
			src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
			<script
				src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js"
				integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns"
			crossorigin="anonymous"></script>
		</head>
		<body>
			<div class="container-fluid bg-primary p-3">
				<div class="row">
					<div class="col-xl-1"></div>
					<div class="col-xl-1 mr-n3"> <a href="${pageContext.request.contextPath}/home">
						<svg xmlns="http://www.w3.org/2000/svg" width="36" height="36" fill="white" class="bi bi-house" viewBox="0 0 16 16">
							<path fill-rule="evenodd" d="M2 13.5V7h1v6.5a.5.5 0 0 0 .5.5h9a.5.5 0 0 0 .5-.5V7h1v6.5a1.5 1.5 0 0 1-1.5 1.5h-9A1.5 1.5 0 0 1 2 13.5zm11-11V6l-2-2V2.5a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5z"/>
							<path fill-rule="evenodd" d="M7.293 1.5a1 1 0 0 1 1.414 0l6.647 6.646a.5.5 0 0 1-.708.708L8 2.207 1.354 8.854a.5.5 0 1 1-.708-.708L7.293 1.5z"/>
						</svg>
					</a>
				</div>
				<div class="col-xl-1 text-white dropdown" style="padding-left:0;padding-right:0">
					<a class="btn btn-primary dropdown-toggle" href="#" role="button"
						id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
					aria-expanded="false"> Categories </a>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
						<c:forEach items="${categories}" var="category">
						
						<a class="dropdown-item"
							href="${pageContext.request.contextPath}/books?categoryName=${category.categoryName}">
						${category.categoryName}</a>
						
						</c:forEach>
						
					</div>
				</div>
				<div class="col-xl-6 text-white mr-2 ">
					<form action="${pageContext.request.contextPath}/books "method="get">
						<div class="input-group ">
							<input type="text" class="form-control" placeholder="title or author you want..."
							aria-label="Search" aria-describedby="basic-addon2" name="keyword">
							<div class="input-group-append">
								<input class="btn btn-outline-light" type="submit" value="Search"></input>
							</div>
						</div>
					</form>
				</div>
				
				<div class="col-xl-1 text-white dropdown mr-5" style="padding-left:0;padding-right:0;">
					<a class="btn btn-primary dropdown-toggle" href="#" role="button"
						id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false">
						<svg xmlns="http://www.w3.org/2000/svg" width="30" height="30" fill="currentColor" class="bi bi-person " viewBox="0 0 16 16">
							<path d="M8 8a3 3 0 1 0 0-6 3 3 0 0 0 0 6zm2-3a2 2 0 1 1-4 0 2 2 0 0 1 4 0zm4 8c0 1-1 1-1 1H3s-1 0-1-1 1-4 6-4 6 3 6 4zm-1-.004c-.001-.246-.154-.986-.832-1.664C11.516 10.68 10.289 10 8 10c-2.29 0-3.516.68-4.168 1.332-.678.678-.83 1.418-.832 1.664h10z"/></svg>
							
							<security:authorize access="!isAuthenticated()">
							Account
							</security:authorize>
							
							<security:authorize access="isAuthenticated()">
							
							<security:authentication property="principal" var="principal"/>
							${principal.username}
							</security:authorize>
						</a>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
							
							
							<security:authorize access="!isAuthenticated()">
							<a class="dropdown-item" href="${pageContext.request.contextPath}/login">Login</a>
							</security:authorize>
							
							
							<security:authorize access="isAuthenticated()">
								<security:authorize access="hasRole('ROLE_ADMIN')">
									<a class="dropdown-item" href="${pageContext.request.contextPath}/admin">Admin page</a>
								</security:authorize>
							<a class="dropdown-item" href="${pageContext.request.contextPath}/bills">Your bills</a>
							<a class="dropdown-item" href="${pageContext.request.contextPath}/user/profile">Profile</a>
							<a class="dropdown-item" href="${pageContext.request.contextPath}/user/password">Change password</a>
							<form id="my_form" action="${pageContext.request.contextPath}/logout" method="POST">
								<!-- Your Form -->
								<a class="dropdown-item" href="javascript:{}" onclick="document.getElementById('my_form').submit(); return false;">Logout</a>
							</form>
							
							</security:authorize>
							
							
						</div>
					</div>
					<div class="col-xl-1 mt-1 custom-link-blue rounded">
						<security:authorize access="isAuthenticated()">
						<a href="${pageContext.request.contextPath}/cart" >
							<svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="white" class="bi bi-cart2" viewBox="0 0 16 16">
								<path d="M0 2.5A.5.5 0 0 1 .5 2H2a.5.5 0 0 1 .485.379L2.89 4H14.5a.5.5 0 0 1 .485.621l-1.5 6A.5.5 0 0 1 13 11H4a.5.5 0 0 1-.485-.379L1.61 3H.5a.5.5 0 0 1-.5-.5zM3.14 5l1.25 5h8.22l1.25-5H3.14zM5 13a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0zm9-1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0z"/></svg>
								<security:authorize access="isAuthenticated()">
								<span class="badge badge-danger position-absolute top-0 start-100 translate-middle ml-n3">${cartCount}</span>
								</security:authorize>
							</a>
							<a href="${pageContext.request.contextPath}/cart" class=" text-white">&nbspCart</a>
							</security:authorize>
							
							<security:authorize access="!isAuthenticated()">
							<a href="${pageContext.request.contextPath}/cart" >
								<svg xmlns="http://www.w3.org/2000/svg" width="32" height="32" fill="white" class="bi bi-cart2" viewBox="0 0 16 16">
									<path d="M0 2.5A.5.5 0 0 1 .5 2H2a.5.5 0 0 1 .485.379L2.89 4H14.5a.5.5 0 0 1 .485.621l-1.5 6A.5.5 0 0 1 13 11H4a.5.5 0 0 1-.485-.379L1.61 3H.5a.5.5 0 0 1-.5-.5zM3.14 5l1.25 5h8.22l1.25-5H3.14zM5 13a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0zm9-1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0z"/></svg>
									
									
								</a>
								<a href="${pageContext.request.contextPath}/login" class=" text-white">&nbspCart</a>
								</security:authorize>
								
								
							</div>
							
							
							
							<div class="col-xl-1"> </div>
						</div>
					</div>
					
				</body>
			</html>