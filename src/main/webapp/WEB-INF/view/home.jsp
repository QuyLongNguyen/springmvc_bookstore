<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!doctype html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
		<title>Home | Hogwarts bookstore</title>
	</head>
	<body class="bg-light">
		<jsp:include page="header.jsp"></jsp:include>
		<div> <br> </div>
		

		<c:set var="count" value="${0}" ></c:set>
		
		<c:forEach items="${categoriesDto}" var="category">
		<c:url var="viewMore" value="/books">
					<c:param name="categoryName" value="${category.categoryName}"></c:param>
					<c:param name="page" value="${0}"></c:param>
				</c:url>
				
				<c:url var="viewDetail" value="/books"> </c:url>
				
		<div class="container bg-white border border-success rounded mb-3">
			<div class=" row row-col-4 justify-content-around ">
			<div class="col-12 p-3 text-center mb-5 text-white h4 bg-success">
					${category.categoryName}		
				</div>
				
			<c:forEach items="${category.books}" var="book">
				<c:if test="${not empty book }">
				<div class="col-xl-2">	
						<div><img alt="image" class="img-fluid"  src="${pageContext.request.contextPath}/resources/images/${book.cover}"></div>
						<div class="mt-2 text-truncate">${book.title} </div>
						<div class="h5 text-danger">$${book.price}</div> 
						<div class="text-center mt-3 mb-3"><a class="btn btn-warning" href="${viewDetail}/${book.bookId}" role="button">View </a></div>  		
				</div>
				</c:if>
			
			</c:forEach>
			
			<div class="col-12 p-1 text-center bg-info">
					<a class="text-white lead" href="${viewMore}">View more</a>		
				</div>
				
			</div>
			
		</div>
		</c:forEach>
			<jsp:include page="footer.jsp"></jsp:include>
		</body>
	</html>