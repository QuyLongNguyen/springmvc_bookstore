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
       	<div class="row mb-3">
       	
       		<div class="col-xl-1">
       			<button type="button" id="sidebarCollapse" class="btn btn-info">
                        <i class="fas fa-align-left"></i>
                 </button>
       		</div>
       	<div class="col-xl-10 text-center h3">
        	Categories Management
         </div>
         </div>
         
       	<div class="row mb-3">
       	<div class="col-xl-3">
        	<a role="button" class="btn btn-info" href="categories/add-category">
           		Add category
         	</a>
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
              <td><a href="${deleteLink}" onclick="return confirm('Are you want to delete ${category.categoryName} ?')"> Delete</a></td>
            </tr>
            
            </c:forEach>
            
          </tbody>
        </table>
        
        
      </div>
      
    </div>
  </body>
</html>