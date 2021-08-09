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
        	Products Management
         </div>
         </div>
	
	<div class="row mb-3">
       	<div class="col-xl-3">
        	<a role="button" class="btn btn-info" href="books/add-book">
           		Add book
         	</a>
         </div>
         </div>
         
	
	<table class="table">
	<thead>
		<tr> 
			<th scope="col">ID</th>
			<th scope="col">Cover</th>
			<th scope="col">Title</th>
			<th scope="col">Author</th>
			<th scope="col">Price</th>
			<th scope="col">Quantity</th>
			<th scope="col">Category</th>
			<th scope="col"></th>
		</tr>
	</thead>
		<c:forEach items="${books}" var="book"> 
		<c:url var="updateLink" value="/admin/books/update-book">
						<c:param name="bookId" value="${book.bookId}" />
		</c:url>
		<c:url var="deleteLink" value="/admin/books/delete-book">
						<c:param name="bookId" value="${book.bookId}" />
		</c:url>
			<tr>
				<td scope="row">${book.bookId}</td>
				<td><img width="123px" height="192px" alt="image" 
				src="${pageContext.request.contextPath }/resources/images/${book.cover}"> </td>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td>${book.price}$</td>
				<td>${book.quantity}</td>
				<td >${book.category.categoryName}</td>
				<td><a href="${updateLink}">Update</a> | 
				<a href="${deleteLink}" onclick="return confirm('Are you want to delete ${book.title} ?')" >Delete</a></td>
			</tr>
		</c:forEach>
		
	</table>
	</div>
	</div>
</body>
</html>