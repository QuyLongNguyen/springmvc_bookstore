 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 <%@ taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
 
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
          Users Management
         </div>
         </div>
         <div class="line"> </div>
    
    <div class="form">
  <form:form action="users/save-user" modelAttribute="user" method="post" >
    <form:hidden path="id"/>
    
      <div class="form-group row">
        <div class="col-xl-1">
        <label class="col-form-label">User name:</label>
        </div>
        <div class="col-xl-3">
        <form:input cssClass="form-control" path="userName" readonly="true"/>
          <form:errors cssClass="failed" path="userName"/> 
        </div>
      </div>  
        
      <div class="form-group row">
        <div class="col-xl-1">
        <label class="col-form-label">First name:</label>
        </div>
        <div class="col-xl-2">
        <form:input cssClass="form-control" path="firstName" readonly="true"/>
        <form:errors cssClass="failed" path="firstName"/>
        </div>
      </div>
        
      <div class="form-group row">
        <div class="col-xl-1">
        <label class="col-form-label">Last name:</label> </div>
        <div class="col-xl-2">
        <form:input  cssClass="form-control p-1" path="lastName" readonly="true"/>
        <form:errors cssClass="failed" path="lastName"/>
        </div>
      </div>    

      <div class="form-group row">
        <div class="col-xl-1">  
        <label class="col-form-label">Phone number:</label>
        </div>
        <div class="col-xl-2">
        <form:input cssClass="form-control" path="phoneNumber"  readonly="true"/>
          <form:errors cssClass="failed" path="phoneNumber"/>
          </div>
      </div>  
      
      <div class="form-group row">
      <div class="col-xl-1">
        <label class="col-form-label">Email:</label>
        </div>
        <div class="col-xl-4">
        <form:input  cssClass="form-control"  path="email" readonly="true"/>
          <form:errors cssClass="failed" path="email"/> 
            </div>
      </div>  
      <div class="form-group row">  
      <div class="col-xl-1">
        <label class="col-form-label">Address:</label>
        </div>
        <div class="col-xl-4">
        <form:textarea cssClass="form-control rounded-0" path="address"  rows="5" readonly="true"/>
        </div>
      </div>  
      
      

      <div class="form-group row">
      <div class="col-xl-1">
        <label class="col-form-label">Roles:</label>
      </div>
      <div class="col-xl-2 ml-4">
  
       
       <c:forEach items="${allRoles}" var="role">
       	
           	<br><form:checkbox cssClass="form-check-input" path="roles" value="${role}"/>
           	<label class="form-check-label"> ${role.name}</label>
        </c:forEach>
           
    
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
  

</body>
</html>