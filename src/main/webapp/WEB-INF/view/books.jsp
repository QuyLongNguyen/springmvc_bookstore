<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
prefix="security"%>
<!doctype html>
<html>
	<head>
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
		<title>${param.categoryName} | Hogwarts bookstore</title>
	</head>
	<body class="bg-light">
		<jsp:include page="header.jsp"></jsp:include>
		
		<div> <br> </div>
		
		<div class="container">
			<nav aria-label="breadcrumb bg-white ">
				<ol class="breadcrumb">
					<li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/">Home</a></li>
					<c:if test="${empty param.keyword }">
					<li class="breadcrumb-item active" aria-current="page">${param.categoryName}</li>
					</c:if>
				</ol>
			</nav>
		</div>
		
		<div class="container bg-white ">
			<div class=" row row-col-4 justify-content-around border border-success rounded ">
				<div class="col-xl-12 border pt-2 pb-2  text-white h3 bg-success rounded mb-3 ">
					<c:if test="${empty param.keyword }">
					${param.categoryName} : ${books.size()} result
					</c:if>
					
					<c:if test="${not empty param.keyword }">
					Result with keyword: "${param.keyword}"
					</c:if>
				</div>
				<c:forEach items="${books}" var="book" varStatus="loop">
				
				<c:url var="viewDetail" value="/books"></c:url>
				
				<div class="col-xl-2 ">
					
					<img alt="image" class="img-fluid" src="${pageContext.request.contextPath}/resources/images/${book.cover}">
					
					<div class="mt-2 text-truncate  ">${book.title} </div>
					<div class="h5 text-danger">$${book.price}</div>
					<div class="text-center"><a class="btn btn-warning mt-2" href="${viewDetail}/${book.bookId}" role="button">View </a></div>
					
					
				</div>
				<br>
				</c:forEach>
				<div class="col-xl-12 pt-2 pb-2 mt-2  text-center bg-light border-bottom border-success rounded">
					
				</div>
			</div>
		</div>
		
  <ul class="pagination justify-content-center mt-3">


	<c:choose>
		<c:when test="${param.page > 0  }">
			<c:url var="previousPage" value="/books">
				<c:param name="categoryName" value="${param.categoryName}"></c:param>
				<c:param name="page" value="${param.page-1}"></c:param>
			</c:url>
			 <li class="page-item">
   				<a class="page-link" href="${previousPage}">Previous</a>
    		</li>
		</c:when>
		<c:otherwise>
			<li class="page-item disabled">
   				<a class="page-link" href="#">Previous</a>
    		</li>
		</c:otherwise>
	</c:choose>
    

    <c:forEach begin="${0}" end="${books.size()/2}" varStatus="loop">
   	<c:url var="page" value="books">
   			<c:param name="categoryName" value="${param.categoryName}"></c:param>
   			<c:param name="page" value="${loop.index}"></c:param>
   	</c:url>
   	
    <li class="page-item"><a class="page-link" href="${page}">${loop.index}</a></li>
 	 </c:forEach>
  
    <c:choose>
		<c:when test="${param.page < books.size() / 2  }">
			<c:url var="nextPage" value="/books">
				<c:param name="categoryName" value="${param.categoryName}"></c:param>
				<c:param name="page" value="${param.page+1}"></c:param>
			</c:url>
			 <li class="page-item">
   				<a class="page-link" href="${nextPage}">Next</a>
    		</li>
		</c:when>
		<c:otherwise>
			<li class="page-item disabled">
   				<a class="page-link" href="#">Next</a>
    		</li>
		</c:otherwise>
	</c:choose>
  </ul>

		<div><br></div>
		<jsp:include page="footer.jsp"></jsp:include>
		
	</body>
</html>