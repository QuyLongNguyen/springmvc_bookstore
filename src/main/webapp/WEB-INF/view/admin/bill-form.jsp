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
         
         
         
     <form:form action="saveBill" modelAttribute="bill" method="POST">
     
			<div class="form-group row"> 
			<div class="col-xl-2">
				<label class="col-form-label">Bill ID:</label>
			
			</div>
			<div class="col-xl-2">
					<form:input path="billId" cssClass="form-control" readonly="true"/>
			</div>
			
			</div>
			
			<div class="form-group row"> 
			<div class="col-xl-2">
				<label class="col-form-label">Date created:</label>
			</div>
			<div class="col-xl-3">
				<!-- <input cssClass="form-control" value="${bill.dateCreated}" readonly="true"/> -->
				<input class="form-control" value="${bill.dateCreated}" readonly="readonly">
			</div>
			
			</div>
		
			<div class="form-group row"> 
			<div class="col-xl-2">
				<label class="col-form-label">Status type:</label>
			</div>
			
			<div class="col-xl-2">
			<form:select cssClass="form-control" path="statusId">
			<c:forEach items="${status}" var="temp">
				<c:choose>
					<c:when test="${temp.statusId == bill.status.statusId}">
						<option value = "${temp.statusId}" selected="selected">${temp.statusType}</option>
					</c:when>
						<c:otherwise>
						<option value = "${temp.statusId}">${temp.statusType}</option>
					</c:otherwise>
				</c:choose>
					</c:forEach>	
				
			</form:select>
			</div>
			</div>
				
			<div class="form-group row">
			<div class="col-xl-2">
				
			</div>
			<div class="col-xl-2">
			<input class="btn btn-info" type="submit" value="Save" />
			</div>
			</div>
		
		</form:form>
		
			
	<table class="table">
	
		<tr>

			<th scope="col">Item id</th>
			<th scope="col">Book id</th>
			<th scope="col">Price</th>
			<th scope="col">Quantity</th>
			
		</tr>

		<c:forEach items="${billItems}" var="billItem">
			
			<tr>

				<td>${billItem.billItemId}</td>
				<td>${billItem.book.bookId}</td>
				<td>${billItem.price}</td>
				<td>${billItem.quantity}</td>
			</tr>
		</c:forEach>

	</table>
	
	
	
	</div>
	</div>
</body>
</html>