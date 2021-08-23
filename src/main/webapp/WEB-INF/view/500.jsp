<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
  <head>
    <title>500 | Hogwarts Bookstore</title>
    
  </head>
  <body class="bg-light">
    <jsp:include page="header.jsp"></jsp:include>
    <div> <br> </div>
    
   
  <div class="container" style="margin-top:5%; margin-bottom: 17%">
      <div class="row justify-content-center" >
        <div class="col-xl-8 border border-success">
          <div class="row p-3 bg-white">
         
          		
          	
          
         
          		<div class="col-xl-5 border-right border-success">
          			<span class="h4">Error 500! INTERNAL SERVER ERROR </span>
          		</div>
          		<div class=" col-xl-3 ">
          			<div><a href="${pageContext.request.contextPath}/" 
          			class="btn btn-success w-100 h3" role="button"> Go to homepage </a></div>
          			
          		</div>
          		
          	
          </div>
         </div>
        </div>
    </div>
   
  <jsp:include page="footer.jsp" ></jsp:include>
</body>
</html>