<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<html>
<head>
<title>Hogwarts-Bookstore</title>
<style>
.error {
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
        	Categories Management
         </div>
         </div>
         <div class="line"> </div>
	<div class="form">
	<form:form action="save-category" modelAttribute="category"
		method="POST">
		<form:hidden path="categoryId"/>
			<div class="form-group row">
				<label class="col-form-label col-xl-2">Category name:</label>
				<div class="col-xl-3">
				<form:input cssClass="form-control" path="categoryName" /> 
				<form:errors cssClass="error" path="categoryName" />
				</div>
			</div>
			<div><br></div>
			<div class="form-group row">
				<div class="col-xl-2"></div>
				<div class="col-xl-3">
				<input class="btn btn-info" type="submit" value="Save" />
				</div>
			</div>
	</form:form>
	</div>
	</div>
	</div>

	
</body>
</html>