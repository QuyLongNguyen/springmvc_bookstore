<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
prefix="security"%>

<!doctype html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
	</head>
	<body class="bg-light">
		<jsp:include page="header.jsp"></jsp:include>
		
		<div> <br> </div>
		
		
		<c:set var="count" value="${0}" ></c:set>
		<div class="container bg-white ">
			<div class=" row row-col-4 justify-content-around border border-success rounded ">
				<c:forEach items="${books}" var="book" varStatus="loop">
				
				<c:if test="${loop.index % 4 == 0}">
				<c:set var="count" value="${count + 4}"></c:set>
				<div class="col-xl-12 border pt-2 pb-2 text-center bg-success text-white rounded mb-3 ">
					<span>${book.category.categoryName}</span></div>
					
				</c:if>
					<c:if test="${not empty book}">
					<div class="col-2 ">
						
						<img alt="image" class="img-fluid" src="${pageContext.request.contextPath}/resources/images/${book.cover}">
					
						<div class="mt-2 text-truncate  ">${book.title} </div>
						<div class="h5 text-danger">$${book.price}</div> 
						<div class="text-center"><a class="btn btn-warning  mt-2" href="#" role="button">View </a></div>  
						
						
					</div>
					</c:if>
						
						<c:if test="${loop.index ==  (count - 1) && loop.index != 0 }">
							<div class="col-xl-12 pt-1 pb-1 mt-2 text-center bg-info text-white border-bottom border-success rounded">View more </div>
							<br>
						</c:if>
						
						</c:forEach>
					</div>
				</div>
			</div>
			
		</body>
	</html>