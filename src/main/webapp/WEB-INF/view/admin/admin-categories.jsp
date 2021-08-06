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
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
          <div class="container-fluid">
            <button type="button" id="sidebarCollapse" class="btn btn-info">
            <i class="fas fa-align-left"></i>
            <span></span>
            </button>
            <button class="btn btn-dark d-inline-block d-lg-none ml-auto"
            type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
            aria-expanded="false" aria-label="Toggle navigation">
            <i class="fas fa-align-justify"></i>
            </button>
            
          </div>
        </nav>
       	
       	<div class="row mb-3">
       	<div class="col-xl-3">
        	<button type="button" class="btn btn-info ">
           		Add category
         	</button>
         </div>
         </div>
         
        
        <table class="table">
          <thead>
            <tr>
              <th scope="col">ID</th>
              <th scope="col">Name</th>
              <th scope="col"></th>
              <th scope="col"></th>
               <th scope="col"></th>
            </tr>
          </thead>
          <tbody>
          	<c:forEach items="${categories}" var="category">
          	<c:url var="updateLink" value="/admin/categories/update-category">
       			 <c:param name="categoryId" value="${category.categoryId}" />
      		</c:url>
     		 <c:url var="deleteLink" value="/admin/categories/delete-category">
       			 <c:param name="categoryId" value="${category.categoryId}" />
      		</c:url>
    		 <c:url var="viewBook" value="/admin/books">
        		<c:param name="categoryId" value="${category.categoryId}" />
      		</c:url>
            <tr>
              <th scope="row">${category.categoryId}</th>
              <td>${category.categoryName}</td>
              <td><a href="${viewBook}">View</a></td>
              <td><a href="${updateLink}"> Update </a></td>
              <td><a  href="${deleteLink}"> Delete</a></td>
            </tr>
            
            </c:forEach>
            
          </tbody>
        </table>
        
        
      </div>
      
    </div>
  </body>
</html>