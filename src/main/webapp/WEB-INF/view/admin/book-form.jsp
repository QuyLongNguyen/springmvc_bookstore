 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 
 
<html>
<head>
<title>Hogwarts-Bookstore</title>
<style>
.error{
	color: red;
}
</style>
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
         <div class="line"> </div>
		
		<div class="form">
	<form:form action="save-book" modelAttribute="book" method="post" enctype="multipart/form-data" >
		<form:hidden path="bookId"/>
		
			<div class="form-group row">
				<div class="col-xl-1">
				<label class="col-form-label">Title:</label>
				</div>
				<div class="col-xl-3">
				<form:input cssClass="form-control" path="title" />
			    <form:errors cssClass="failed" path="title"/> 
				</div>
			</div>	
				
			<div class="form-group row">
				<div class="col-xl-1">
				<label class="col-form-label">Author:</label>
				</div>
				<div class="col-xl-3">
				<form:input cssClass="form-control" path="author" />
				<form:errors cssClass="failed" path="author"/>
				</div>
			</div>
				
			<div class="form-group row">
				<div class="col-xl-1">
				<label class="col-form-label">Publish year:</label> </div>
				<div class="col-xl-1">
				<form:input type="number" cssClass="form-control p-1" path="publishYear" />
				<form:errors cssClass="failed" path="publishYear"/>
				</div>
			</div>		

			<div class="form-group row">	
			<div class="col-xl-1">
				<label class="col-form-label">Description:</label>
				</div>
				<div class="col-xl-4">
				<form:textarea cssClass="form-control rounded-0" path="description"  rows="5"/>
				</div>
			</div>			
					
			<div class="form-group row">
				<div class="col-xl-1">	
				<label class="col-form-label">Price:</label>
				</div>
				<div class="col-xl-2">
				<form:input type="number" step=".01" cssClass="form-control" path="price"  />
			    <form:errors cssClass="failed" path="price"/>
			    </div>
			</div>	
			
			<div class="form-group row">
			<div class="col-xl-1">
				<label class="col-form-label">Quantity:</label>
				</div>
				<div class="col-xl-2">
				<form:input type="number" cssClass="form-control"  path="quantity" />
			    <form:errors cssClass="failed" path="quantity"/> 
			      </div>
			</div>	
			
			<div class="form-group row">
			
				<div class="col-xl-1">
				<label class="col-form-label">Image:</label>
				</div>
				<div class="col-xl-1">
				<form:input cssClass="btn btn-light p-0" path="image" type="file"/>
				</div>
				<form:hidden path="cover"/>
			</div>	
			
			<c:if test="${book.cover != null }">
			<div class="form-group row">
			<div class="col-xl-1">
			
			</div>
			<div class="col-xl-2">
			<img width="100px" height="168px" alt="image" 
				src="${pageContext.request.contextPath }/resources/images/${book.cover}"> 
			</div>
			</div>
			</c:if>
					
			<div class="form-group row">	
			<div class="col-xl-1">
				<label class="col-form-label">Category:</label>
			</div>
			<div class="col-xl-2">
				<form:select cssClass="form-control" path="categoryId">
				<c:forEach items="${categories}" var="category">
					<c:choose>
						
						<c:when test="${category.categoryId == book.category.categoryId}">
							<option value = "${category.categoryId}" selected="selected">${category.categoryName}</option>
						</c:when>
						<c:otherwise>
							<option value = "${category.categoryId}">${category.categoryName}</option>
						</c:otherwise>
					</c:choose>
				</c:forEach>	
				</form:select> 
			</div>
			</div>
				
			<div class="form-group row">
			<div class="col-xl-1">
				
			</div>
			<div class="col-xl-2">
			<input class="btn btn-info" type="submit" value="Save" />
			</div>
			</div>
					
	</form:form>
	</div>
	</div>
	</div>
	
	<a href="${pageContext.request.contextPath}/admin">Back to admin page</a>
</body>
</html>